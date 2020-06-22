package com.imooc.mybatis.entity;

/**
 * User
 *
 * @author HSY
 * @since 2020/06/21 13:25
 */
public class User {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 姓名
     */
    private String username;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 分数
     */
    private Integer score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public User() {
    }

    public User(Integer id, Integer age) {
        this.id = id;
        this.age = age;
    }

    public User(String username, Integer age, Integer score) {
        this.username = username;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
