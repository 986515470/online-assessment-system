package com.qiqiao.controller;

import com.alibaba.fastjson.JSONObject;
import com.qiqiao.model.students;
import com.qiqiao.service.studentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Wcy
 * @Date 2021/4/16 19:42
 */
@Controller
@RequestMapping
public class studentController {

    @Resource
    private studentService studentService;




//    @RequestMapping(value = "/Login",method = RequestMethod.GET)
    @PostMapping("/Login")
    @ResponseBody
    public void Login(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username +"\t"+password);
        students sure=studentService.selectByUsername(username);
        if(username.equals("admin"))
           System.out.println("管理员登录成功！");
        else
            System.out.println(sure.getName()+"登录成功！");

        if(username.equals("admin")&&password.equals("admin"))//设定管理员账号
            response.sendRedirect("manage.html");
        else
            if (!username.equals("admin")&&sure.getPassword().equals(password)) {

                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(60 * 60);//设置session过期时间 为60分钟
                session.setAttribute("username", username);//一卡通
                session.setAttribute("name", sure.getName());//姓名
                session.setAttribute("id", sure.getId());//自增id
                response.sendRedirect("index.html");
            } else
                response.sendRedirect("login.html");


    }


//    @RequestMapping("/getUserSession")
//    @ResponseBody
//    public String getUserSession(HttpServletRequest request, HttpSession httpSession) {
//        JSONObject jsonObject = new JSONObject();
//        if(httpSession!=null){
//            jsonObject.put("username", httpSession.getAttribute("username"));
//        }
//        return JSONObject.toJSONString(jsonObject);
//    }




//    @RequestMapping(value = "/Register",method = RequestMethod.GET)
    @PostMapping("/Register")
    @ResponseBody
    public void Register(HttpServletResponse response,HttpServletRequest request) throws IOException {
        String name = request.getParameter("name");
        String classes = request.getParameter("classes");
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        String fangxiang = request.getParameter("fangxiang");


            students newStu =new students();
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String dateNowStr = sdf.format(d);

            newStu.setName(name);
            newStu.setClasses(classes);
            newStu.setPassword(password);
            newStu.setTime(dateNowStr);
            newStu.setUsername(username);
            newStu.setFangxiang(fangxiang);

            studentService.insert(newStu);
            response.sendRedirect("login.html");

    }




    @RequestMapping("/deleteByPrimaryKey")
    @ResponseBody
    public int deleteByPrimaryKey(Integer id) {
        return studentService.deleteByPrimaryKey(id);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public int insert(students record) {
        return studentService.insert(record);
    }

    @RequestMapping("/selectByPrimaryKey")
    @ResponseBody
    public students selectByPrimaryKey(Integer id) {
        return studentService.selectByPrimaryKey(id);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    @ResponseBody
    public int updateByPrimaryKeySelective(students record) {
        return studentService.updateByPrimaryKeySelective(record);
    }

    @RequestMapping("/updateByPrimaryKey")
    @ResponseBody
    public int updateByPrimaryKey(students record) {
        return studentService.updateByPrimaryKey(record);
    }

    @RequestMapping("/findAllStudents")
    @ResponseBody
    public List<students> findAllStudents() {
        return studentService.findAllStudents();
    }

    @RequestMapping("/findStudentByName")
    @ResponseBody
    public List<students> findStudentByName(String name) {
        return studentService.findStudentByName(name);
    }




}






