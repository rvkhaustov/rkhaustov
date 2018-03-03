package ru.rkhaustov.testtask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by rvkha_000 on 07.02.2018.
 */
public abstract class TestBase {
    /**
     * X - max.
     */
    static final int X = 2;
    /**
     * Y - max.
     */
    static final int Y = 2;

    /**
     * lockBoard.
     */
    public ReentrantLock[][] lockBoard;

    /**
     * stopThread.
     */
    boolean stopThread;

    /**
     * x.
     */
    int x;

    /**
     * y.
     */
    int y;

    /**
     * result.
     */
    boolean result;

    /**
     * playerFirst.
     */
    List<Players> players;

    /**
     * blocks.
     */
    List<Block> blocks;

    /**
     * countMonster.
     */
    int countMonster;
    /**
     * countBomberman.
     */
    int countBomberman;
    /**
     * countBlock.
     */
    int countBlock;

    /**
     * befor.
     */
    public void before() {

        this.x = 2;
        this.y = 2;

        this.result = true;
        this.countMonster = 2;
        this.countBomberman = 1;
        this.countBlock = 2;
        stopThread = false;

        this.players = new ArrayList<>(this.countMonster + this.countBomberman);
        lockBoard = new ReentrantLock[X + 1][Y + 1];

        for (int x = 0; x <= X; x++) {
            for (int y = 0; y <= Y; y++) {
                lockBoard[x][y] = new ReentrantLock();
            }
        }
        this.blocks = new ArrayList<>(countBlock);
        blocks.add(new Block(1, 1));
        blocks.add(new Block(1, 2));
        blocks.stream().forEach(block -> lockBoard[block.getX()][block.getY()].lock());
        int item = 0;
        for (; item < countMonster; item++) {
            this.players.add(new Monster(lockBoard,
                    ThreadLocalRandom.current().nextInt(this.X),
                    ThreadLocalRandom.current().nextInt(this.Y), "monster:" + item));
            this.players.get(item).setMaxXY(X,Y);
        }
        this.players.add(new Bomberman(lockBoard, 0, 0, "bomberman:0"));
        lockBoard[0][0].lock();
        this.players.get(item).setMaxXY(X,Y);
    }
}
