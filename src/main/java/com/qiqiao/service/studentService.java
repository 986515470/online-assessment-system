package com.qiqiao.service;

import com.qiqiao.model.students;

import java.util.List;

/**
 * @author Wcy
 * @Date 2021/4/16 19:29
 */

public interface studentService {
    int deleteByPrimaryKey(Integer id);

    int insert(students record);//插入一个

//    int insertSelective(students record);

    students selectByPrimaryKey(Integer id);//按id查找

    int updateByPrimaryKeySelective(students record);

    int updateByPrimaryKey(students record);

    List<students> findAllStudents();

    List<students> findStudentByName(String name);

    students selectByUsername(String username );

}
