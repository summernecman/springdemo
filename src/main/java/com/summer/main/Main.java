package com.summer.main;

import com.summer.main.bean.NoteBean;
import com.summer.util.GsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by SWSD on 2017-07-19.
 */
@Controller
@RequestMapping("/note")
public class Main {

    NoteDataOpe noteDataOpe = new NoteDataOpe();

    @RequestMapping(value = "/notelist",method = RequestMethod.POST)
    public void hello(HttpServletRequest req, HttpServletResponse rep){
        String str = req.getParameter("data");
        NoteBean noteBean = GsonUtil.getInstance().fromJson(str,NoteBean.class);
        System.out.println(str);
        try {
            PrintWriter printWriter = rep.getWriter();
            printWriter.println(noteDataOpe.getNoteList(noteBean.getObjectId()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/addnotebook",method = RequestMethod.POST)
    public void addNoteBook(HttpServletRequest req, HttpServletResponse rep){
        String str = req.getParameter("data");
        NoteBean noteBean = GsonUtil.getInstance().fromJson(str,NoteBean.class);
        System.out.println(str);
        try {
            PrintWriter printWriter = rep.getWriter();
            printWriter.println(noteDataOpe.addNoteBook(noteBean));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
