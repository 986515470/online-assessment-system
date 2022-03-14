package com.qiqiao.controller;

import com.alibaba.fastjson.JSONObject;
import com.qiqiao.file.AliOssCloudUtil;
import com.qiqiao.model.project;
import com.qiqiao.model.students;
import com.qiqiao.service.projectService;
import com.qiqiao.service.studentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
/**
 * @author Wcy
 * @Date 2021/4/23 17:06
 */
@RestController
public class unloadFile {

    @Resource
    private com.qiqiao.service.projectService projectService;

    @Resource
    private com.qiqiao.service.studentService studentService;


    /**
     * 文件上传
     * @param file
     * @return
     */
    @PostMapping("/file/upload")
    public JSONObject upload(@RequestParam("file") MultipartFile file, HttpServletRequest servletRequest) {

        JSONObject res = new JSONObject();
        JSONObject resUrl = new JSONObject();

        String filename = file.getResource().getFilename();//文件名称
        System.out.println(filename);
        //这里文件名用了uuid 防止重复，可以根据自己的需要来写
//        String name = UUID.randomUUID() + filename.substring(filename.lastIndexOf("."), filename.length());
        String name=filename;
//        name = name.replace("-", "");

        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("上传失败");
        }
        AliOssCloudUtil util = new AliOssCloudUtil();
        //上传成功返回完整路径的url
        String url = util.uploadFile2OSS(inputStream, name);
        System.out.println("上传成功："+url);

        /**
         * 以下开始保存用户上传信息
         */

        HttpSession session=servletRequest.getSession();
        String username=session.getAttribute("username").toString();
        System.out.println("用户Session:"+studentService.selectByUsername(username).toString());
        students student=studentService.selectByUsername(username);

//        保存上传信息
        double filesize=file.getSize();
        String size=String.format("%.2f", filesize/(1024*1024)).toString();
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String posttime= sdf.format(d);
        String namea=student.getName();
        String classes=student.getClasses();
        String fangxiang=student.getFangxiang();

        project newProject=new project();
        newProject.setProjectname(filename);//项目名称
        newProject.setSize(size+"M");//文件大小
        newProject.setPosttime(posttime);//提交时间
        newProject .setName(namea);//姓名
        newProject.setClasses(classes);//班级
        newProject.setUsername(username);//用户名&一卡通
        newProject.setFangxiang(fangxiang);//方向
        newProject.setHref(url);//

        projectService.insert(newProject);

        return res;//返回一个空jsonObject避免接口报错，不影响程序正常运行

    }

    /**
     * 判断文件是否存在
     * @param fileName  储存的文件名
     * @return
     */
    @GetMapping("/file/exists")
    public Boolean exists(String fileName) {
        AliOssCloudUtil util = new AliOssCloudUtil();
        Boolean bool = util.doesObjectExist(fileName);
        return bool;
    }


    /**
     * 下载oss对应文件
     * @param fileName 储存的文件名
     * @return
     */
    @PostMapping("/file/downLoad")
    public void downloadFile(String fileName, HttpServletResponse response) {
        try {
            AliOssCloudUtil ossClientUtil = new AliOssCloudUtil();
            InputStream is = ossClientUtil.getInputStreamByFileUrl(ossClientUtil.getFiledir() + fileName);
            // 配置文件下载
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            // 下载文件能正常显示中文
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[1024];
            int len = -1;
            while ((len = is.read(b)) != -1) {
                os.write(b, 0, len);
            }
            is.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}