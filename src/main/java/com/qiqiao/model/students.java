package com.qiqiao.model;

public class students {
    private Integer id;

    private String name;

    private String classes;

    private String password;

    private String time;

    private String username;
    private String fangxiang;

    public students(Integer id, String name, String classes, String password, String time, String username,String fangxiang) {
        this.id = id;
        this.name = name;
        this.classes = classes;
        this.password = password;
        this.time = time;
        this.username = username;
        this.fangxiang=fangxiang;
    }

    public students() {

    }

    public String getFangxiang() {
        return fangxiang;
    }

    public void setFangxiang(String fangxiang) {
        this.fangxiang = fangxiang;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                ", password='" + password + '\'' +
                ", time='" + time + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}