package com.qiqiao.mapper;

import com.qiqiao.model.students;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface studentsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(students record);

    int insertSelective(students record);

    students selectByPrimaryKey(Integer id);

    students selectByUsername(String username );

    int updateByPrimaryKeySelective(students record);

    int updateByPrimaryKey(students record);

    List<students> findAllStudents();

    List<students> findStudentByName(String name);
}