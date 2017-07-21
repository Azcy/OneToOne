package com.zcy.OneToOne.test;

import com.zcy.OneToOne.domain.Clazz;
import com.zcy.OneToOne.domain.Student;
import com.zcy.OneToOne.mapper.ClazzMapper;
import com.zcy.OneToOne.mapper.StudentMapper;
import com.zcy.OneToOne.util.FKSqlSessionFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by zcy on 2017/7/21.
 */
public class OneToMany {
    public static void main(String[] args) throws IOException {
        //读取mybatis-config.xml文件
        InputStream inputStream= Resources.getResourceAsStream("mybatis-config.xml");
        //初始化mybatis,创建SqlSessionFactory类的实例
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        //创建Session实例
        SqlSession session=sqlSessionFactory.openSession();
        OneToMany t=new OneToMany();
        //测试一对多
        t.testSelectClazzById(session);
       // t.testSelectStudentById(session);
        //提交事务
        session.commit();
        //关闭Session
        session.close();

    }
    //测试一对多，查询班级Clazz(1)的时候级联查询学生Student(多)
    public void testSelectClazzById(SqlSession session){
        //获得ClazzMapper接口的代理对象
        ClazzMapper cm=session.getMapper(ClazzMapper.class);
        //调用selectClazzById方法
        Clazz clazz=cm.selectClazzById(1);
        System.out.println(clazz);

    }

    //测试多对一，查询学生Student(多)时级联查询班级Clazz(一)
    public void testSelectStudentById(SqlSession session){
        //获取StudentMapper接口的代理对象
        StudentMapper sm=session.getMapper(StudentMapper.class);
        //调用selectStudentById方法
        Student stu=sm.selectStudentById(1);
        //查看查询到的student对象信息
        System.out.println(stu);
        //查看Student对象关联的班级信息
        System.out.println(stu.getClazz());
        System.out.println("test.....,通过班级id查找学生信息");
        List<Student> students=sm.selectStudentByClazzId(1);
        for (Student student :students){
            System.out.println(student);
        }
    }
}
