package com.summer.main.bean;

import com.summer.base.bean.BaseBean;

import java.util.ArrayList;

/**
 * Created by SWSD on 2017-07-28.
 */
public class NoteListBean extends BaseBean {

    private int size;

    private ArrayList<NoteOrBookBean> data;

    public ArrayList<NoteOrBookBean> getData() {
        return data;
    }

    public void setData(ArrayList<NoteOrBookBean> data) {
        this.data = data;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
