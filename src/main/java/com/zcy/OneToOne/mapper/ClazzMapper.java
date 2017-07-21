package com.zcy.OneToOne.mapper;

import com.zcy.OneToOne.domain.Clazz;

/**
 * Created by zcy on 2017/7/21.
 */
public interface ClazzMapper {
    //根据id查询班级信息
    Clazz selectClazzById(Integer id);
}
