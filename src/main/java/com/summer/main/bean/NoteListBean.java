package com.summer.main.bean;

import com.summer.base.bean.BaseBean;

import java.util.ArrayList;

/**
 * Created by SWSD on 2017-07-28.
 */
public class NoteListBean extends BaseBean {

    ArrayList<NoteBean> data;

    public ArrayList<NoteBean> getData() {
        return data;
    }

    public void setData(ArrayList<NoteBean> data) {
        this.data = data;
    }
}
