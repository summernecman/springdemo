package com.summer.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
@RequestMapping("/aaa")
public class Main {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public void hello(HttpServletRequest req, HttpServletResponse rep){
        try {
            PrintWriter printWriter = rep.getWriter();
            printWriter.println("fdfdfdfdfdf");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/hello23",method = RequestMethod.GET)
    public void hello23(HttpServletRequest req, HttpServletResponse rep){
        try {
            PrintWriter printWriter = rep.getWriter();
            printWriter.println("fdstgvvv分人人2");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
