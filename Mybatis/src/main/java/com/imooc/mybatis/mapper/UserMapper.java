package com.imooc.mybatis.mapper;

import com.imooc.mybatis.entity.User;
import com.imooc.mybatis.model.UserShortCut;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * UserMapper
 *
 * @author HSY
 * @since 2020/06/20 23:34
 */
@Mapper
public interface UserMapper {

    /**
     * 根据id获取姓名
     * @param id    主键
     * @return  {@link String} 姓名
     */
    @Select("select username from imooc_user where id = #{id}")
    String selectUsernameById(Integer id);

    /**
     * 根据id获取年龄
     * @param id    主键
     * @return  {@link Integer} 年龄
     */
    Integer selectUserAgeById(Integer id);

    /**
     * 查询用户
     * @param user   用户
     * @return  {@link User}
     */
    @Select("select id, " +
            "username, " +
            "age, " +
            "score " +
            "from imooc_user " +
            "where age = #{age} and score = #{score};")
    User selectUserByAgeAndScore(User user);

    /**
     * 查询用户
     * @param user   用户
     * @return  {@link User}
     */
    User selectUserByAgeAndScoreWithXml(User user);

    /**
     * 获取姓名和年龄
     * @return  {@link List<UserShortCut>}
     */
    @Results({
            @Result(property = "username", column = "username"),
            @Result(property = "age", column = "age")
    })
    @Select("select * from imooc_user")
    List<UserShortCut> selectUsernameAndAge ();


    /**
     * 获取姓名和年龄
     * @return  {@link List<UserShortCut>}
     */
    List<UserShortCut> selectUsernameAndAgeWithXml ();

    /**
     * 插入用户
     * @param user  用户信息
     * @return  {@link Integer}
     */
    @Insert("insert into imooc_user(id,username,age,score) values(#{id},#{username},#{age},#{score})")
    Integer insertUser (User user);

    Integer insertUserWithXml (User user);
}
