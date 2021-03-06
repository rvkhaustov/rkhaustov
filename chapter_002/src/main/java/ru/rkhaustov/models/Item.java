package ru.rkhaustov.models;
import java.util.Date;
/**
 * Created by rvkha_000 on 24.04.2017.
 * @version 1.0
 */
public class Item {
    /**
     * @param id номер заявки.
     */
    private String id = "10";
    /**
     * @param name имя.
     */
    private String name;
    /**
     * @param desc описание.
     */
    private String desc;
    /**
     * @param created - дата создания.
     */
    private long created;
    /**
     * @param comments - комментарии.
     */
    private String comments;

    /**
     *
     * @param id номер заявки
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param name имя
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return name имя
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param created дата создания
     */
    public void setCreated(long created) {
        this.created = created;
    }

    /**
     *
     * @return created дата создания
     */
    public long getCreated() {
        return created;
    }

    /**
     *
     * @param comments комментарии
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     *
     * @return comments комментарии
     */
    public String getComments() {
        return comments;
    }

    /**
     *
     * @param desc описание
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     *
     * @return desc описание
     */
    public String getDesc() {
        return desc;
    }

    /**
     *
     * @param name имя
     * @param desc описание
     * @param created дата создания
     */
    public Item(String name, String desc, long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }
    /**
     * @param id id
     * @param name имя
     * @param desc описание
     * @param created дата создания
     */
    public Item(String id, String name, String desc, long created) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.created = created;
    }

    @Override
    public String toString() {
        return     String.format("Id: %16s; Name: %10s; Description: %20s; Date: %s",
                this.getId(),
                this.getName(),
                this.getDesc(),
                new Date(this.getCreated()).toString());
    }
}