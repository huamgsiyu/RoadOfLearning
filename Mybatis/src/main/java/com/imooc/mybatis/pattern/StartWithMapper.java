package com.imooc.mybatis.pattern;

import com.imooc.mybatis.entity.User;
import com.imooc.mybatis.mapper.UserMapper;
import com.imooc.mybatis.model.UserShortCut;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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

    @Test
    public void selectUserByAgeAndScore () throws IOException {
        String resources = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setAge(18);
        user.setScore(100);
        User selectUser = userMapper.selectUserByAgeAndScore(user);
        System.out.println("selectUser = " + selectUser.toString());
        sqlSession.close();
    }

    @Test
    public void selectUserByAgeAndScoreWithXml () throws IOException {
        String resources = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User paramUser = new User();
        paramUser.setAge(18);
        paramUser.setScore(100);
        User user = mapper.selectUserByAgeAndScoreWithXml(paramUser);
        System.out.println("user = " + user);
        sqlSession.close();
    }

    @Test
    public void selectUsernameAndAge () throws IOException {
        String resources = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<UserShortCut> userShortCuts = mapper.selectUsernameAndAge();
        userShortCuts.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void selectUsernameAndAgeWithXml () throws IOException {
        String resources = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<UserShortCut> userShortCuts = mapper.selectUsernameAndAgeWithXml();
        userShortCuts.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void insertUser () throws IOException {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(10);
        user.setUsername("hsy");
        user.setAge(11);
        user.setScore(1000);
        Integer integer = mapper.insertUser(user);
        sqlSession.commit();
        System.out.println("integer = " + integer);
        sqlSession.close();

    }

    @Test
    public void insertUserWithXml () throws IOException {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(11);
        user.setUsername("hsy1");
        user.setAge(111);
        user.setScore(10001);
        Integer integer = mapper.insertUser(user);
        sqlSession.commit();
        System.out.println("integer = " + integer);
        sqlSession.close();

    }

    @Test
    public void insertUserNoId () throws IOException {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User("hsy", 22, 1024);
        Integer integer = mapper.insertUserNoId(user);
        sqlSession.commit();
        System.out.println("id = " + user.getId());
        sqlSession.close();
    }

    @Test
    public void insertUserNoIdWithXml () throws IOException {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User("hsy", 22, 1024);
        Integer integer = mapper.insertUserNoIdWithXml(user);
        sqlSession.commit();
        System.out.println("id = " + user.getId());
        sqlSession.close();
    }

    @Test
    public void updateAgeById () throws IOException {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(11, 38);
        Integer integer = mapper.updateAgeById(user);
        System.out.println("更新是否成功 = " + (integer == 0 ? "失败" : "成功"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateAgeByIdWithXml () throws IOException {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(11, 39);
        Integer integer = mapper.updateAgeByIdWithXml(user);
        System.out.println("更新是否成功 = " + (integer == 0 ? "失败" : "成功"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUserById () throws IOException {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Integer integer = mapper.deleteUserById(1);
        System.out.println("删除是否成功 = " + (integer == 0 ? "失败" : "成功"));
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void deleteUserByIdWithXml () throws IOException {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Integer integer = mapper.deleteUserByIdWithXml(3);
        System.out.println("删除是否成功 = " + (integer == 0 ? "失败" : "成功"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void ognlOr () throws IOException {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("hsy");
        user.setAge(11);
//        user.setScore(100);
        List<User> users = mapper.ognlOr(user);
        users.forEach(System.out::println);
        sqlSession.close();
    }
}
