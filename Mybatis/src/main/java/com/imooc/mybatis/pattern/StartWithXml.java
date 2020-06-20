package com.imooc.mybatis.pattern;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * StartWithXml
 *
 * @author HSY
 * @since 2020/06/20 23:23
 */
public class StartWithXml {
    public static void main(String[] args) throws IOException, SQLException {
        // 配置式使用Mybatis
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        // 按照配置得到SQLSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 信件绘画
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行SQl
        PreparedStatement preparedStatement = sqlSession.getConnection()
                .prepareStatement("select * from imooc_user where id = ?");
        preparedStatement.setInt(1, 1);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("username = " + resultSet.getString("username"));
        }
        sqlSession.close();
    }
}
