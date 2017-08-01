package com.summer.main;

import com.summer.base.bean.BaseBean;
import com.summer.main.bean.NoteOrBookBean;
import com.summer.util.GsonUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by SWSD on 2017-07-19.
 */
@Controller
@RequestMapping("/note")
public class Main {

    NoteDataOpe noteDataOpe = new NoteDataOpe();

    @RequestMapping(value = "/notelist",method = RequestMethod.POST)
    public void hello(HttpServletRequest req, HttpServletResponse rep){
        init(req,rep);
        String str = req.getParameter("data");
        NoteOrBookBean noteOrBookBean = GsonUtil.getInstance().fromJson(str,NoteOrBookBean.class);
        System.out.println(str);
        try {
            PrintWriter printWriter = rep.getWriter();
            printWriter.println(noteDataOpe.getNoteList(noteOrBookBean.getObjectId()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/addnotebook",method = RequestMethod.POST)
    public void addNoteBook(HttpServletRequest req, HttpServletResponse rep){
        init(req,rep);
        String str = req.getParameter("data");
        NoteOrBookBean noteOrBookBean = GsonUtil.getInstance().fromJson(str,NoteOrBookBean.class);
        System.out.println(str);
        try {
            PrintWriter printWriter = rep.getWriter();
            printWriter.println(noteDataOpe.addNoteBook(noteOrBookBean));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/addnote",method = RequestMethod.POST)
    public void addNote(HttpServletRequest req, HttpServletResponse rep){
        init(req,rep);
        String str = req.getParameter("data");
        NoteOrBookBean noteOrBookBean = GsonUtil.getInstance().fromJson(str,NoteOrBookBean.class);
        System.out.println(str);
        try {
            PrintWriter printWriter = rep.getWriter();
            printWriter.println(noteDataOpe.addNote(noteOrBookBean));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/updatenote",method = RequestMethod.POST)
    public void updateNote(HttpServletRequest req, HttpServletResponse rep){
        init(req,rep);
        String str = req.getParameter("data");
        NoteOrBookBean noteOrBookBean = GsonUtil.getInstance().fromJson(str,NoteOrBookBean.class);
        System.out.println(str);
        try {
            PrintWriter printWriter = rep.getWriter();
            printWriter.println(noteDataOpe.updateData(noteOrBookBean));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/addfiles",method = RequestMethod.POST)
    public void addFiles(HttpServletRequest req, HttpServletResponse rep){
        init(req,rep);
        DiskFileItemFactory factory = new DiskFileItemFactory();
        File parent = new File("D://file");
        factory.setRepository(parent);
        factory.setSizeThreshold(1024*1024);
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            ArrayList<FileItem> list = (ArrayList<FileItem>) upload.parseRequest(req);
            for(int i=0;i<list.size();i++){
                list.get(i).getInputStream();

                File file = new File(parent,list.get(i).getName());
                if(!file.exists()){
                    file.createNewFile();
                }
                list.get(i).write(file);
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void init(HttpServletRequest req, HttpServletResponse rep){
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        rep.setCharacterEncoding("UTF-8");
        rep.setContentType("application/json;charset=UTF-8");
    }
}
