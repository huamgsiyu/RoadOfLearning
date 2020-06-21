package com.imooc.mybatis.model;


/**
 * @author huangsiyu
 */
public class UserShortCut {

    /**
     * 姓名
     */
    private String username;

    /**
     * 年龄
     */
    private Integer age;

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

    @Override
    public String toString() {
        return "UserShortCut{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
