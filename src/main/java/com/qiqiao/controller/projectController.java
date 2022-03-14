package com.qiqiao.controller;

import com.alibaba.fastjson.JSONObject;
import com.qiqiao.model.project;
import com.qiqiao.model.score;
import com.qiqiao.model.students;
import com.qiqiao.service.projectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Wcy
 * @Date 2021/4/19 17:06
 */
@Controller
@RequestMapping
public class projectController {

    @Resource
    private projectService projectService;


    @Resource
    private com.qiqiao.service.studentService studentService;


    public void setProjectService(com.qiqiao.service.projectService projectService) {
        this.projectService = projectService;
    }


    @RequestMapping("/deleteByProjectPrimaryKey")
    @ResponseBody
    public int deleteByProjectPrimaryKey(Integer id) {
        return projectService.deleteByPrimaryKey(id);
    }


    @RequestMapping("/insertProjectSelective")
    @ResponseBody
    public int insertProjectSelective(project record) {
        return projectService.insertSelective(record);
    }

    @RequestMapping("/selectByProjectPrimaryKey")
    @ResponseBody
    public project selectByProjectPrimaryKey(Integer id) {
        return projectService.selectByPrimaryKey(id);
    }

    @RequestMapping("/updateByProjectPrimaryKeySelective")
    @ResponseBody
    public int updateByProjectPrimaryKeySelective(project record) {
        return projectService.updateByPrimaryKeySelective(record);
    }

    @RequestMapping("/updateByProjectPrimaryKey")
    @ResponseBody
    public int updateByProjectPrimaryKey(project record) {

        return projectService.updateByPrimaryKey(record);
    }

    @RequestMapping("/updateByProjectId0")
    @ResponseBody
    public void updateByProjectId0(HttpServletResponse response, String id, String stugrade) throws IOException {
        int i = Integer.parseInt(id);
        int n = Integer.parseInt(stugrade);
        project project = projectService.selectByPrimaryKey(i);
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String dateNowStr = sdf.format(d);
        project.setTime(dateNowStr);
        project.setScore(n);
        projectService.updateByPrimaryKey(project);
        response.sendRedirect("ManageLog0.html");
    }

    @RequestMapping("/updateByProjectId")
    @ResponseBody
    public void updateByProjectId(HttpServletResponse response, String id, String stugrade) throws IOException {
        int i = Integer.parseInt(id);
        int n = Integer.parseInt(stugrade);
        project project = projectService.selectByPrimaryKey(i);
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String dateNowStr = sdf.format(d);
        project.setTime(dateNowStr);
        project.setScore(n);
        projectService.updateByPrimaryKey(project);
        response.sendRedirect("ManageLog.html");
    }
    @RequestMapping("/updateByProjectId1")
    @ResponseBody
    public void updateByProjectId1(HttpServletResponse response, String id, String stugrade) throws IOException {
        int i = Integer.parseInt(id);
        int n = Integer.parseInt(stugrade);
        project project = projectService.selectByPrimaryKey(i);
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String dateNowStr = sdf.format(d);
        project.setTime(dateNowStr);
        project.setScore(n);
        projectService.updateByPrimaryKey(project);
        response.sendRedirect("ManageLog1.html");
    }
    @RequestMapping("/updateByProjectId2")
    @ResponseBody
    public void updateByProjectId2(HttpServletResponse response, String id, String stugrade) throws IOException {
        int i = Integer.parseInt(id);
        int n = Integer.parseInt(stugrade);
        project project = projectService.selectByPrimaryKey(i);
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String dateNowStr = sdf.format(d);
        project.setTime(dateNowStr);
        project.setScore(n);
        projectService.updateByPrimaryKey(project);
        response.sendRedirect("ManageLog2.html");
    }

    @RequestMapping("/findAllProjects")
    @ResponseBody
    public List<project> findAllProjects() {
        return projectService.findAllProjects();
    }

    @GetMapping("/findQDPlay")
    @ResponseBody
    public List<project> findPlayProjects() {
        List<project> pro =  new ArrayList<>();
        List<students> stu= studentService.findAllStudents();
        double score,count;
        for (students a:stu) {
//            ---
            project ppp=new project();
            ppp.setId(a.getId());
            ppp.setName(a.getName());
            ppp.setUsername(a.getUsername());
            ppp.setClasses(a.getClasses());
            ppp.setFangxiang(a.getFangxiang());
            ppp.setTime(a.getTime());
//            ---
            score=0;count=0;
                List<project> gra = projectService.selectByFangxiang("前端");

                for (project p:gra) {
                   if(a.getUsername().equalsIgnoreCase(p.getUsername())&&p.getScore()!=null){
                       score=score+p.getScore();
                       count++;
                   }
                }
            int g=new Double(score/count).intValue();
            if(g==0) g=-1;
            ppp.setScore(g);


            pro.add(ppp);
        }
        return pro;
    }

    @GetMapping("/findHDPlay")
    @ResponseBody
    public List<project> findHDPlay() {
        List<project> pro =  new ArrayList<>();
        List<students> stu= studentService.findAllStudents();
        double score,count;
        for (students a:stu) {
//            ---
            project ppp=new project();
            ppp.setId(a.getId());
            ppp.setName(a.getName());
            ppp.setUsername(a.getUsername());
            ppp.setClasses(a.getClasses());
            ppp.setFangxiang(a.getFangxiang());
            ppp.setTime(a.getTime());
//            ---
            score=0;count=0;
            List<project> gra = projectService.selectByFangxiang("后端");

            for (project p:gra) {
                if(a.getUsername().equalsIgnoreCase(p.getUsername())&&p.getScore()!=null){
                    score=score+p.getScore();
                    count++;
                }
            }
            int g=new Double(score/count).intValue();
            if(g==0) g=-1;
            ppp.setScore(g);


            pro.add(ppp);
        }
        return pro;
    }

    @GetMapping("/findDSJPlay")
    @ResponseBody
    public List<project> findDSJPlay() {
        List<project> pro =  new ArrayList<>();
        List<students> stu= studentService.findAllStudents();
        double score,count;
        for (students a:stu) {
//            ---
            project ppp=new project();
            ppp.setId(a.getId());
            ppp.setName(a.getName());
            ppp.setUsername(a.getUsername());
            ppp.setClasses(a.getClasses());
            ppp.setFangxiang(a.getFangxiang());
            ppp.setTime(a.getTime());
//            ---
            score=0;count=0;
            List<project> gra = projectService.selectByFangxiang("大数据");

            for (project p:gra) {
                if(a.getUsername().equalsIgnoreCase(p.getUsername())&&p.getScore()!=null){
                    score=score+p.getScore();
                    count++;
                }
            }
            int g=new Double(score/count).intValue();
            if(g==0) g=-1;
            ppp.setScore(g);

            pro.add(ppp);
        }
        return pro;
    }


    @GetMapping("/findProjectsByFangxiang")
    @ResponseBody
    public List<project> findProjectsByFangxiang(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String fangxiang = request.getParameter("fangxiang");
        System.out.println("查询：" + name + "\t" + fangxiang);
        if (name != null || fangxiang != null) {
            List<project> a = projectService.selectByFangxiang(fangxiang);
            List<project> b = projectService.selectByName(name);
            a.addAll(b);
            return a;
        } else
            return projectService.findAllProjects();

    }


    @RequestMapping("/findProjectsByName")
    @ResponseBody
    public List<project> selectByUsername(String username) {
        return projectService.selectByUsername(username);
    }

    @RequestMapping("/getUserSession")
    @ResponseBody
    public List<project> getUserSession(HttpServletRequest request, HttpSession httpSession) {

        String username = (String) httpSession.getAttribute("username");
        System.out.println("获取用户Session——username：" + username);
        return projectService.selectByUsername(username);

    }

    @RequestMapping("/getQDPlayData")
    @ResponseBody
    public List<score> getPlayScore() {


        int A = 0, B = 0, C = 0, D = 0, E = 0, F = 0, G = 0, H = 0, I = 0, J = 0;
        List<students> students = studentService.findAllStudents();//先获取所有学生的信息
        int playscore, count ;
        for (students a : students) {
            playscore = 0;
            count = 0;
            List<project> AStudentGrades = projectService.selectByUsername(a.getUsername());//获得该学生的所有项目成绩信息
            if (AStudentGrades != null) {
                for (project b : AStudentGrades) {
                    if (b.getScore() != null && b.getFangxiang().equalsIgnoreCase("前端")) {
//                       System.out.println(b.getScore()+"\t");
                        playscore = b.getScore() + playscore;
                        count = count + 1;
                    }
                }
            }
            if (count != 0) {
                playscore = playscore / count;//平均成绩
            } else
                playscore = -1;//暂无成绩则为-1

            if (playscore >= 96 && playscore <= 100) A++;
            if (playscore >= 92 && playscore <= 95) B++;
            if (playscore >= 88 && playscore <= 91) C++;
            if (playscore >= 84 && playscore <= 87) D++;
            if (playscore >= 80 && playscore <= 83) E++;
            if (playscore >= 76 && playscore <= 79) F++;
            if (playscore >= 72 && playscore <= 75) G++;
            if (playscore >= 68 && playscore <= 71) H++;
            if (playscore >= 64 && playscore <= 67) I++;
            if (playscore >= 60 && playscore <= 63) J++;

        }
        List<score> score = new ArrayList<>();
        score.add(new score(A, B, C, D, E, F, G, H, I, J));
        System.out.println("前端：" + A + " " + B + " " + C + " " + D + " " + E + " " + F + " " + G + " " + H + " " + I + " " + J);
        return score;
    }

    @RequestMapping("/getHDPlayData")
    @ResponseBody
    public List<score> getHDPlayData() {



        int A = 0, B = 0, C = 0, D = 0, E = 0, F = 0, G = 0, H = 0, I = 0, J = 0;
        List<students> students = studentService.findAllStudents();//先获取所有学生的信息
        int playscore, count ;
        for (students a : students) {
            playscore = 0;
            count = 0;
            List<project> AStudentGrades = projectService.selectByUsername(a.getUsername());//获得该学生的所有项目成绩信息
            if (AStudentGrades != null) {
                for (project b : AStudentGrades) {
                    if (b.getScore() != null && b.getFangxiang().equalsIgnoreCase("后端")) {
//                       System.out.println(b.getScore()+"\t");
                        playscore = b.getScore() + playscore;
                        count = count + 1;
                    }
                }
            }
            if (count != 0) {
                playscore = playscore / count;//平均成绩
            } else
                playscore = -1;//暂无成绩则为-1

            if (playscore >= 96 && playscore <= 100) A++;
            if (playscore >= 92 && playscore <= 95) B++;
            if (playscore >= 88 && playscore <= 91) C++;
            if (playscore >= 84 && playscore <= 87) D++;
            if (playscore >= 80 && playscore <= 83) E++;
            if (playscore >= 76 && playscore <= 79) F++;
            if (playscore >= 72 && playscore <= 75) G++;
            if (playscore >= 68 && playscore <= 71) H++;
            if (playscore >= 64 && playscore <= 67) I++;
            if (playscore >= 60 && playscore <= 63) J++;

        }
        List<score> score = new ArrayList<>();
        score.add(new score(A, B, C, D, E, F, G, H, I, J));
        System.out.println("后端：" + A + " " + B + " " + C + " " + D + " " + E + " " + F + " " + G + " " + H + " " + I + " " + J);
        return score;
    }

    @RequestMapping("/getDSJPlayData")
    @ResponseBody
    public List<score> getDSJPlayData() {


        int A = 0, B = 0, C = 0, D = 0, E = 0, F = 0, G = 0, H = 0, I = 0, J = 0;
        List<students> students = studentService.findAllStudents();//先获取所有学生的信息
        int playscore, count ;
        for (students a : students) {
            playscore = 0;
            count = 0;
            List<project> AStudentGrades = projectService.selectByUsername(a.getUsername());//获得该学生的所有项目成绩信息
            if (AStudentGrades != null) {
                for (project b : AStudentGrades) {
                    if (b.getScore() != null && b.getFangxiang().equalsIgnoreCase("大数据")) {
//                       System.out.println(b.getScore()+"\t");
                        playscore = b.getScore() + playscore;
                        count = count + 1;
                    }
                }
            }
            if (count != 0) {
                playscore = playscore / count;//平均成绩
            } else
                playscore = -1;//暂无成绩则为-1

            if (playscore >= 96 && playscore <= 100) A++;
            if (playscore >= 92 && playscore <= 95) B++;
            if (playscore >= 88 && playscore <= 91) C++;
            if (playscore >= 84 && playscore <= 87) D++;
            if (playscore >= 80 && playscore <= 83) E++;
            if (playscore >= 76 && playscore <= 79) F++;
            if (playscore >= 72 && playscore <= 75) G++;
            if (playscore >= 68 && playscore <= 71) H++;
            if (playscore >= 64 && playscore <= 67) I++;
            if (playscore >= 60 && playscore <= 63) J++;

        }
        List<score> score = new ArrayList<>();
        score.add(new score(A, B, C, D, E, F, G, H, I, J));
        System.out.println("大数据：" + A + " " + B + " " + C + " " + D + " " + E + " " + F + " " + G + " " + H + " " + I + " " + J);
        return score;
    }

    @RequestMapping("/getALLPlayData")
    @ResponseBody
    public List<score> getALLPlayData() {

        int A = 0, B = 0, C = 0, D = 0, E = 0, F = 0, G = 0, H = 0, I = 0, J = 0;
        List<project> students = projectService.findAllProjects();//先获取所有学生的成绩信息
        int  count = 0;
        for (project a : students) {
            if (a.getScore() != null) {

                if (a.getScore() >= 96 && a.getScore() <= 100) A++;
                if (a.getScore() >= 92 && a.getScore() <= 95) B++;
                if (a.getScore() >= 88 && a.getScore() <= 91) C++;
                if (a.getScore() >= 84 && a.getScore() <= 87) D++;
                if (a.getScore() >= 80 && a.getScore() <= 83) E++;
                if (a.getScore() >= 76 && a.getScore() <= 79) F++;
                if (a.getScore() >= 72 && a.getScore() <= 75) G++;
                if (a.getScore() >= 68 && a.getScore() <= 71) H++;
                if (a.getScore() >= 64 && a.getScore() <= 67) I++;
                if (a.getScore() >= 60 && a.getScore() <= 63) J++;

                count = count + 1;

            }
        }

        System.out.println("成绩个数："+count);
        List<score> scorew = new ArrayList<>();
        scorew.add(new score(A, B, C, D, E, F, G, H, I, J));
        System.out.println("所有成绩：" + A + " " + B + " " + C + " " + D + " " + E + " " + F + " " + G + " " + H + " " + I + " " + J);
        return scorew;
    }

}


