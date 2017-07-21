package com.zcy.OneToOne.mapper;

import com.zcy.OneToOne.domain.Order;

/**
 * Created by zcy on 2017/7/21.
 */
public interface OrderMapper {
    Order selectOrderById(int id);
}
