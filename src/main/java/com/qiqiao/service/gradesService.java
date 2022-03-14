package com.qiqiao.service;

import com.qiqiao.model.grades;

import java.util.List;

/**
 * @author Wcy
 * @Date 2021/4/19 12:57
 */
public interface gradesService {
    int deleteByPrimaryKey(Integer id);

    int insert(grades record);

    int insertSelective(grades record);

    grades selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(grades record);

    int updateByPrimaryKey(grades record);

    List<grades> findStudentGrades();
}
