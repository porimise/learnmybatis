package com.allen.test;

import com.allen.dao.EmployeeMapper;
import com.allen.domain.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author allen
 * @date 2018/8/8
 */
public class TestEmployee {



        public SqlSessionFactory getSqlSessionFactory(String resource) {
            InputStream inputStream = null;

            try {
                inputStream = Resources.getResourceAsStream(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return new SqlSessionFactoryBuilder().build(inputStream);
        }

        @Test
        public void testSelect() {
            SqlSessionFactory sqlSessionFactory = getSqlSessionFactory("config/mybatis_config.xml");
            SqlSession sqlSession = sqlSessionFactory.openSession();

            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = employeeMapper.selectEmployeeById(2);
            System.out.println(employee);
        }
}
