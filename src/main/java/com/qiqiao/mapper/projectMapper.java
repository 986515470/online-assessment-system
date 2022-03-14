package com.qiqiao.mapper;

import com.qiqiao.model.project;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface projectMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(project record);

    int insertSelective(project record);

    project selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(project record);

    int updateByPrimaryKey(project record);

    List<project> findAllProjects();

    List<project> selectByUsername(String username);

    List<project> selectByFangxiang(String fangxiang );

    List<project> selectByName(String name );
}