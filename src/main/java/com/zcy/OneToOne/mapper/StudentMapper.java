package com.zcy.OneToOne.mapper;

import com.zcy.OneToOne.domain.Student;

import java.util.List;

/**
 * Created by zcy on 2017/7/21.
 */
public interface StudentMapper {
    //根据id查询学生信息
    Student selectStudentById(Integer id);

    //根据班级id查询学生信息
    List<Student> selectStudentByClazzId(Integer id);

}
