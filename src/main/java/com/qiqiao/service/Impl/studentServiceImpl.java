package com.qiqiao.service.Impl;

import com.qiqiao.mapper.studentsMapper;
import com.qiqiao.model.students;
import com.qiqiao.service.studentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Wcy
 * @Date 2021/4/16 19:33
 */
@Service("studentService")
public class studentServiceImpl implements studentService {

    @Resource
    private  studentsMapper studentsMapper;

    public void setMapper(studentsMapper studentsMapper) {
        this.studentsMapper = studentsMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return studentsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(students record) {
        return studentsMapper.insert(record);
    }

    @Override
    public students selectByPrimaryKey(Integer id) {
        return studentsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(students record) {
        return studentsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(students record) {
        return studentsMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<students> findAllStudents() {
        return studentsMapper.findAllStudents();
    }

    @Override
    public List<students> findStudentByName(String name) {
        return studentsMapper.findStudentByName(name);
    }

    @Override
    public students selectByUsername(String username) {
        return studentsMapper.selectByUsername(username);
    }
}
