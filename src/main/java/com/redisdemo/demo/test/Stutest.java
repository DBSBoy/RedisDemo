package com.redisdemo.demo.test;

import com.redisdemo.demo.Entity.Student;
import com.redisdemo.demo.StuMapper.StuMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Stutest  {

     void findById ()throws IOException{
         InputStream in= Resources.getResourceAsStream("templates/StuBatisConfig.xml");
         SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
         SqlSession sqlSession=sqlSessionFactory.openSession();
         StuMapper mapper=sqlSession.getMapper(StuMapper.class);
         Student stu=mapper.getStuById(2);
         System.out.println(stu.toString());
    }
}
