package com.summer.main;


import com.summer.base.bean.BaseResBean;
import com.summer.main.bean.NoteBean;
import com.summer.main.bean.NoteOrBookBean;
import com.summer.util.GsonUtil;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by SWSD on 2017-07-12.
 */
public class NoteDataOpe implements NoteDataI{


    public String getNoteList(int objectId) {
        BaseResBean resBean =  new BaseResBean();
        ArrayList<NoteOrBookBean> noteBeen = new ArrayList<NoteOrBookBean>();
        String str = "select * from note WHERE parentId = ? ";
        PreparedStatement ps = null;
        ResultSet set=null;
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            ps = connection.prepareStatement(str);
            ps.setInt(1,objectId);
             set = ps.executeQuery();
            while (set.next()){
                NoteOrBookBean noteOrBookBean = new NoteOrBookBean();
                noteOrBookBean.setObjectId(set.getInt(set.findColumn("objectId")));
                noteOrBookBean.setParentId(set.getInt(set.findColumn("parentId")));
                noteOrBookBean.setType(set.getInt(set.findColumn("type")));
                noteOrBookBean.setName(set.getString(set.findColumn("name")));
                noteOrBookBean.setData(GsonUtil.getInstance().fromJson(set.getString(set.findColumn("data")), NoteBean.class));
                noteOrBookBean.setCreatedAt(set.getString(set.findColumn("createdAt")));
                noteOrBookBean.setUpdatedAt(set.getString(set.findColumn("updatedAt")));
                noteBeen.add(noteOrBookBean);
            }
            resBean.setData(noteBeen);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,ps,set);
        }
        return GsonUtil.getInstance().toJson(resBean);
    }


    public String getNoteDetail(int objectId) {
        BaseResBean resBean =  new BaseResBean();
        ArrayList<NoteOrBookBean> noteBeen = new ArrayList<NoteOrBookBean>();
        String str = "select * from note WHERE objectId = ? ";
        PreparedStatement ps = null;
        Connection connection = null;
        try {
             connection = DBUtil.getConnection();
            ps = connection.prepareStatement(str);
            ps.setInt(1,objectId);
            ResultSet set = ps.executeQuery();
            while (set.next()){
                NoteOrBookBean noteOrBookBean = new NoteOrBookBean();
                noteOrBookBean.setObjectId(set.getInt(set.findColumn("objectId")));
                noteOrBookBean.setParentId(set.getInt(set.findColumn("parentId")));
                noteOrBookBean.setType(set.getInt(set.findColumn("type")));
                noteOrBookBean.setName(set.getString(set.findColumn("name")));
                noteOrBookBean.setData(GsonUtil.getInstance().fromJson(set.getString(set.findColumn("data")), NoteBean.class));
                noteOrBookBean.setCreatedAt(set.getString(set.findColumn("createdAt")));
                noteOrBookBean.setUpdatedAt(set.getString(set.findColumn("updatedAt")));
                noteBeen.add(noteOrBookBean);
            }
            resBean.setData(noteBeen);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,ps,null);
        }
        return GsonUtil.getInstance().toJson(resBean);
    }

    public String addNoteBook(NoteOrBookBean bean) {
        String str = "insert into note(parentId,type,name,data,createdAt,updatedAt) value(?,?,?,?,?,?)";
        PreparedStatement ps = null;
        Connection connection = null;
        try {
             connection = DBUtil.getConnection();
            ps = connection.prepareStatement(str);
            ps.setInt(1,bean.getParentId());
            ps.setString(2,"0");
            ps.setString(3,bean.getName());
            ps.setString(4,GsonUtil.getInstance().toJson(bean.getData()));
            ps.setDate(5, new Date(System.currentTimeMillis()));
            ps.setDate(6, new Date(System.currentTimeMillis()));
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,ps,null);
        }
        return GsonUtil.getInstance().toJson(new BaseResBean());
    }

    public String addNote(NoteOrBookBean bean) {
        String str = "insert into note(parentId,type,name,data,createdAt,updatedAt) value(?,?,?,?,?,?)";
        PreparedStatement ps = null;
        Connection connection = null;
        try {
             connection = DBUtil.getConnection();
            ps = connection.prepareStatement(str);
            ps.setInt(1,bean.getParentId());
            ps.setString(2,"1");
            ps.setString(3,bean.getName());
            ps.setString(4,GsonUtil.getInstance().toJson(bean.getData()));
            ps.setDate(5, new Date(System.currentTimeMillis()));
            ps.setDate(6, new Date(System.currentTimeMillis()));
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,ps,null);
        }
        return GsonUtil.getInstance().toJson(new BaseResBean());
    }

    public String updateData(NoteOrBookBean bean) {
        String str = "update note set data = ? where objectId = ? ";
        PreparedStatement ps = null;
        Connection connection = null;
        try {
             connection = DBUtil.getConnection();
            ps = connection.prepareStatement(str);
            ps.setString(1,GsonUtil.getInstance().toJson(bean.getData()));
            ps.setInt(2,bean.getObjectId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,ps,null);
        }
        return GsonUtil.getInstance().toJson(new BaseResBean());
    }


    public String updateNoteName(NoteOrBookBean bean) {
        String str = "update note set name = ? where objectId = ? ";
        PreparedStatement ps = null;
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            ps = connection.prepareStatement(str);
            ps.setString(1,bean.getName());
            ps.setInt(2,bean.getObjectId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,ps,null);
        }
        return GsonUtil.getInstance().toJson(new BaseResBean());
    }

    public String deleteNote(NoteOrBookBean bean) {
        String str = "delete FROM note  where objectId = ? ";
        PreparedStatement ps = null;
        Connection connection = null;
        try {
             connection = DBUtil.getConnection();
            ps = connection.prepareStatement(str);
            ps.setInt(1,bean.getObjectId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,ps,null);
        }
        return GsonUtil.getInstance().toJson(new BaseResBean());
    }

    public String deleteNoteBook(NoteOrBookBean bean) {
        String str = "delete FROM note  where parentId = ? ";
        PreparedStatement ps = null;
        Connection connection = null;
        try {
             connection = DBUtil.getConnection();
            ps = connection.prepareStatement(str);
            ps.setInt(1,bean.getParentId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection,ps,null);
        }
        return GsonUtil.getInstance().toJson(new BaseResBean());
    }
}
