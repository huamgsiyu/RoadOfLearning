package com.imooc.mybatis.pattern;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * StartNoXml
 *
 * @author HSY
 * @since 2020/06/20 22:04
 */

public class StartNoXml {
    public static void main(String[] args) throws SQLException {
        // 无需xml配置的方式使用MyBatis
        // 准备jdbc事务类
        JdbcTransactionFactory jdbcTransactionFactory = new JdbcTransactionFactory();
        // 配置数据源
        PooledDataSource dataSource = new PooledDataSource("com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/imooc?useSSL=false&serverTimezone=Asia/Shanghai",
                "root",
                "huangsiyu@168");
        // 配置环境，向环境中指定环境id、事务和数据源
        Environment environment = new Environment.Builder("development")
                .transactionFactory(jdbcTransactionFactory)
                .dataSource(dataSource)
                .build();
        // 新建Mybatis配置类
        Configuration configuration = new Configuration(environment);
        // 得到一个SQLSessionFactory 核心类
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        // 开始一个SQL 会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 得到一个SQL连接，并执行SQL语句
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
