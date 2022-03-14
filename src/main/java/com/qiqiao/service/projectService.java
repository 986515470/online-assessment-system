package com.qiqiao.service;

import com.qiqiao.model.project;
import com.qiqiao.model.students;

import java.util.List;

/**
 * @author Wcy
 * @Date 2021/4/19 17:00
 */
public interface projectService {

    int deleteByPrimaryKey(Integer id);

    int insert(project record);

    int insertSelective(project record);

    project selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(project record);

    int updateByPrimaryKey(project record);

    List<project> findAllProjects();

    List<project> selectByUsername(String username );

    List<project> selectByFangxiang(String fangxiang );

    List<project> selectByName(String name );
}
