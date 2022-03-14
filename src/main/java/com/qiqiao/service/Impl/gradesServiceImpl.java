package com.qiqiao.service.Impl;

import com.qiqiao.mapper.gradesMapper;
import com.qiqiao.mapper.studentsMapper;
import com.qiqiao.model.grades;
import com.qiqiao.service.gradesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Wcy
 * @Date 2021/4/19 13:00
 */
@Service
public class gradesServiceImpl implements gradesService {

    @Resource
    private gradesMapper gradesMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return gradesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(grades record) {
        return gradesMapper.insert(record);
    }

    @Override
    public int insertSelective(grades record) {
        return gradesMapper.insertSelective(record);
    }

    @Override
    public grades selectByPrimaryKey(Integer id) {
        return gradesMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(grades record) {
        return gradesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(grades record) {
        return gradesMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<grades> findStudentGrades() {
        return gradesMapper.findStudentGrades();
    }
}
