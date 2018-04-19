package ru.rkhaustov.tracker;

import java.util.Date;

/**
 * Created by rvkha_000 on 24.04.2017.
 *
 * @version 1.0
 */
public class Item {
    /**
     * @param id номер заявки.
     */
    private String id;
    /**
     * @param name имя.
     */
    private String name;
    /**
     * @param desc описание.
     */
    private String description;
    /**
     * @param created - дата создания.
     */
    private Long created;
    /**
     * @param comments - комментарии.
     */
    private String comments;

    /**
     * @param id номер заявки
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param name имя
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return name имя
     */
    public String getName() {
        return name;
    }

    /**
     * @param created дата создания
     */
    public void setCreated(Long created) {
        this.created = created;
    }

    /**
     * @return created дата создания
     */
    public Long getCreated() {
        return created;
    }

    /**
     * @param comments комментарии
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * @return comments комментарии
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param description описание
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return desc описание
     */
    public String getDescription() {
        return description;
    }

    /**
     * Empty constructor.
     */
    public Item() {
    }

    /**
     * @param name        имя
     * @param description описание
     * @param created     дата создания
     */
    public Item(String name, String description, long created) {
        this.name = name;
        this.description = description;
        this.created = created;
    }

    /**
     * @param id          id
     * @param name        имя
     * @param description описание
     * @param created     дата создания
     */
    public Item(String id, String name, String description, long created) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created = created;
    }

    /**
     * @param id          id
     * @param name        имя
     * @param description описание
     * @param comments comments
     * @param created     дата создания
     */
    public Item(String id, String name, String description, String comments, long created) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created = created;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return String.format("Id: %16s; Name: %10s; Description: %20s; Date: %s",
                this.getId(),
                this.getName(),
                this.getDescription(),
                this.getCreated() != null ? new Date(this.getCreated()) : null);
    }
}