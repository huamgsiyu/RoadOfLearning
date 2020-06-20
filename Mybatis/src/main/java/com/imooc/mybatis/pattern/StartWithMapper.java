package com.imooc.mybatis.pattern;

import com.imooc.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * StartWithMapper
 *
 * @author HSY
 * @since 2020/06/20 23:42
 */
public class StartWithMapper {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Integer age = mapper.selectUserAgeById(1);
        System.out.println("age = " + age);
        String username = mapper.selectUsernameById(1);
        System.out.println("username = " + username);
        sqlSession.close();
    }
}
