package com.summer.main.bean;

import com.summer.base.bean.BaseBean;

/**
 * Created by SWSD on 2017-07-28.
 */
public class NoteOrBookBean extends BaseBean{

    private int objectId;

    private int parentId;

    private int type;

    private String name;

    private NoteBean data;

    private String createdAt;

    private String updatedAt;

    public int getObjectId() {
        return objectId;
    }

    public void setObjectId(int objectId) {
        this.objectId = objectId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NoteBean getData() {
        return data;
    }

    public void setData(NoteBean data) {
        this.data = data;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
