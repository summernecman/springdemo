package com.summer.main;


import com.google.gson.Gson;
import com.summer.base.bean.BaseResBean;
import com.summer.main.bean.NoteBean;
import com.summer.main.bean.NoteListBean;
import com.summer.util.DateFormatUtil;
import com.summer.util.GsonUtil;

import java.awt.geom.Area;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by SWSD on 2017-07-12.
 */
public class NoteDataOpe implements NoteDataI{


    public String getNoteList(int objectId) {
        BaseResBean resBean =  new BaseResBean();
        NoteListBean noteListBean = new NoteListBean();
        ArrayList<NoteBean> noteBeen = new ArrayList<NoteBean>();
        String str = "select * from note WHERE parentId = ? ";
        try {
            PreparedStatement ps = DBHelper.getInstance().conn.prepareStatement(str);
            ps.setInt(1,objectId);
            ResultSet set = ps.executeQuery();
            while (set.next()){
                NoteBean noteBean = new NoteBean();
                noteBean.setObjectId(set.getInt(1));
                noteBean.setParentId(set.getInt(2));
                noteBean.setType(set.getString(3));
                noteBean.setName(set.getString(4));
                noteBean.setData(set.getString(5));
                noteBean.setCreatedAt(set.getString(6));
                noteBean.setUpdatedAt(set.getString(7));
                noteBeen.add(noteBean);
            }
            noteListBean.setData(noteBeen);
            resBean.setData(noteListBean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return GsonUtil.getInstance().toJson(resBean);
    }

    public String addNoteBook(NoteBean bean) {
        String str = "insert into note(parentId,type,name,data,createdAt,updatedAt) value(?,?,?,?,?,?)";
        try {
            PreparedStatement ps= DBHelper.getInstance().conn.prepareStatement(str);
            ps.setInt(1,bean.getParentId());
            ps.setString(2,"0");
            ps.setString(3,bean.getName());
            ps.setString(4,bean.getData().toString());
            ps.setDate(5, new Date(System.currentTimeMillis()));
            ps.setDate(6, new Date(System.currentTimeMillis()));
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return GsonUtil.getInstance().toJson(new BaseResBean());
    }

    public String addNote(NoteBean bean) {
        return GsonUtil.getInstance().toJson(new BaseResBean());
    }
}
