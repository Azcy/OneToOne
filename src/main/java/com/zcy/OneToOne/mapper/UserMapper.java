package com.zcy.OneToOne.mapper;

import com.zcy.OneToOne.domain.User;

/**
 * Created by zcy on 2017/7/21.
 */
public interface UserMapper {
    User selectUserById(int id);
}
