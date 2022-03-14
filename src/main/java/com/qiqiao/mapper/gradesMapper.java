package com.qiqiao.mapper;

import com.qiqiao.model.grades;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface gradesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(grades record);

    int insertSelective(grades record);

    grades selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(grades record);

    int updateByPrimaryKey(grades record);

    List<grades> findStudentGrades();
}