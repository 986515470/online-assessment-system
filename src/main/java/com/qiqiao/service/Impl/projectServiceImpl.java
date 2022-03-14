package com.qiqiao.service.Impl;

import com.qiqiao.mapper.projectMapper;
import com.qiqiao.model.project;
import com.qiqiao.service.projectService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Wcy
 * @Date 2021/4/19 17:01
 */
@Service
public class projectServiceImpl implements projectService {

    @Resource
    private projectMapper projectMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return projectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(project record) {
        return projectMapper.insert(record);
    }

    @Override
    public int insertSelective(project record) {
        return projectMapper.insertSelective(record);
    }

    @Override
    public project selectByPrimaryKey(Integer id) {
        return projectMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(project record) {
        return projectMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(project record) {
        return projectMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<project> findAllProjects() {
        return projectMapper.findAllProjects();
    }

    @Override
    public List<project> selectByUsername(String username) {
        return projectMapper.selectByUsername(username);
    }

    @Override
    public List<project> selectByFangxiang(String fangxiang) {
        return projectMapper.selectByFangxiang(fangxiang);
    }

    @Override
    public List<project> selectByName(String name) {
        return projectMapper.selectByName(name);
    }
}
