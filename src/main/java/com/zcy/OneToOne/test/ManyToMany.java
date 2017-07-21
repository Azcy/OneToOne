package com.zcy.OneToOne.test;

import com.sun.tools.corba.se.idl.constExpr.Or;
import com.zcy.OneToOne.domain.Article;
import com.zcy.OneToOne.domain.Order;
import com.zcy.OneToOne.domain.User;
import com.zcy.OneToOne.mapper.OrderMapper;
import com.zcy.OneToOne.mapper.UserMapper;
import com.zcy.OneToOne.util.FKSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by zcy on 2017/7/21.
 */
public class ManyToMany {
    public static void main(String[] args) {
        SqlSession session= FKSqlSessionFactory.getSqlSession();
        ManyToMany m=new ManyToMany();
        m.testSelectOrderById(session);
        m.testSelectUserById(session);

        session.commit();
        session.close();
    }

    //测试一对多关系，查询User(一)的时候级联查询订单Order(多)
    public void testSelectUserById(SqlSession session){
        //获取UserMapper接口的代理对象
        UserMapper um=session.getMapper(UserMapper.class);
        User user=um.selectUserById(1);
        //查看查询到的user 对象信息
        System.out.println("user:----->");
        System.out.println(user);
        //查看user对象关联的订单信息
        System.out.println("user.order:----->");
        List<Order> orders=user.getOrders();
        for (Order order:orders){
            System.out.println(order);
        }
    }

    //测试多对多关系，查询订单Order(多)的时候级联查询订单的商品Article(多)
    public void testSelectOrderById(SqlSession session){
        //获得OrderMapper接口的代理对象
        OrderMapper om=session.getMapper(OrderMapper.class);
        //调用selectOrderById方法
        Order order=om.selectOrderById(2);
        //查看查询到的order对象信息
        System.out.println("order:----->");
        System.out.println(order);

        System.out.println("order.article:----->");
        //查看order对象关联的商品信息
        List<Article> articles=order.getArticles();
        for (Article article:articles){
            System.out.println(article);
        }
    }
}
