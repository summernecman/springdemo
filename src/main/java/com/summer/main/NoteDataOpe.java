package com.summer.main;


import com.summer.base.bean.BaseResBean;
import com.summer.main.bean.NoteBean;
import com.summer.main.bean.NoteListBean;
import com.summer.util.GsonUtil;

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
        ArrayList<NoteBean> noteBeen = new ArrayList<NoteBean>();
        String str = "select * from note WHERE parentId = ? ";
        try {
            PreparedStatement ps = DBHelper.getInstance().conn.prepareStatement(str);
            ps.setInt(1,objectId);
            ResultSet set = ps.executeQuery();
            while (set.next()){
                NoteBean noteBean = new NoteBean();
                noteBean.setObjectId(set.getInt(set.findColumn("objectId")));
                noteBean.setParentId(set.getInt(set.findColumn("parentId")));
                noteBean.setType(set.getInt(set.findColumn("type")));
                noteBean.setName(set.getString(set.findColumn("name")));
                noteBean.setData(set.getString(set.findColumn("data")));
                noteBean.setCreatedAt(set.getString(set.findColumn("createdAt")));
                noteBean.setUpdatedAt(set.getString(set.findColumn("updatedAt")));
                noteBeen.add(noteBean);
            }
            resBean.setData(noteBeen);

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
        String str = "insert into note(parentId,type,name,data,createdAt,updatedAt) value(?,?,?,?,?,?)";
        try {
            PreparedStatement ps= DBHelper.getInstance().conn.prepareStatement(str);
            ps.setInt(1,bean.getParentId());
            ps.setString(2,"1");
            ps.setString(3,bean.getName());
            ps.setString(4,GsonUtil.getInstance().toJson(bean.getData()));
            ps.setDate(5, new Date(System.currentTimeMillis()));
            ps.setDate(6, new Date(System.currentTimeMillis()));
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return GsonUtil.getInstance().toJson(new BaseResBean());
    }

    public String updateData(NoteBean bean) {
        String str = "update note set data = ? where objectId = ? ";
        try {
            PreparedStatement ps= DBHelper.getInstance().conn.prepareStatement(str);
            ps.setString(1,GsonUtil.getInstance().toJson(bean.getData()));
            ps.setInt(2,bean.getObjectId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return GsonUtil.getInstance().toJson(new BaseResBean());
    }
}
