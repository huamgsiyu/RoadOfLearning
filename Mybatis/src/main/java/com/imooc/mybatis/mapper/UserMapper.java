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

    /**
     * 插入用户
     * @param user  用户信息
     * @return  {@link Integer}
     */
    Integer insertUserWithXml (User user);

    /**
     * 插入用户
     * @param user  用户信息
     * @return  {@link Integer} 改变行数
     */
    @Insert("insert into imooc_user(username, age, score) values(#{username}, #{age}, #{score})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer insertUserNoId (User user);

    /**
     * 插入用户
     * @param user  用户信息
     * @return  {@link Integer} 改变行数
     */
    Integer insertUserNoIdWithXml (User user);

    /**
     * 更新年龄
     * @param user    用户
     * @return  {@link Integer}
     */
    @Update("update imooc_user set age = #{age} where id = #{id}")
    Integer updateAgeById (User user);

    /**
     * 更新年龄
     * @param user    用户
     * @return  {@link Integer}
     */
    Integer updateAgeByIdWithXml (User user);

    /**
     * 删除用户
     * @param id    主键
     * @return  {@link Integer} 变动行数
     */
    @Delete("delete from imooc_user where id = #{id}")
    Integer deleteUserById (Integer id);


    /**
     * 删除用户
     * @param id    主键
     * @return  {@link Integer} 变动行数
     */
    Integer deleteUserByIdWithXml (Integer id);

    /**
     * 查询多个用户
     * @param user  用户
     * @return  {@link List<User>}
     */
    List<User> ognlOr (User user);

    /**
     * 查询用户信息
     * @param user  查询条件
     * @return  {@link List<User>}
     */
    @Select({"<script>",
            "select id, ",
                "username, ",
            "age, ",
            "score ",
            "from imooc_user ",
            "where username = #{username} ",
                "<when test='age != null'>",
                    "and age = #{age}",
                "</when>",
                "<when test='score != null'>",
                    "and score = #{score}",
                "</when>",
            "</script>"})
    List<User> selectUserByNameCondition (User user);

    /**
     * 查询用户信息
     * @param user  查询条件
     * @return  {@link List<User>}
     */
    List<User> selectUserByNameConditionWithXml (User user);

    /**
     * 查询用户
     * @param user  用户信息
     * @return  {@link List<User>}
     */
    @Select({"<script>",
            "select * ",
            "from imooc_user",
            "where ",
            "<choose>",
                "<when test='id != null'>",
                    "id = #{id}",
                "</when>",
                "<when test='username != null'>",
                    "username = #{username}",
                "</when>",
                "<otherwise>",
                    "1 = 1",
                "</otherwise>",
            "</choose>",
        "</script>"
    })
    List<User> selectUserByIdOrName (User user);

    /**
     * 查询用户
     * @param user  用户信息
     * @return  {@link List<User>}
     */
    List<User> selectUserByIdOrNameWithXml (User user);

    /**
     * 查询用户
     * @param user  用户信息
     * @return  {@link List<User>}
     */
    @Select({"<script>",
                "select * from imooc_user",
                "<where>",
                    "<if test='id != null'>",
                        "id = #{id}",
                    "</if>",
                    "<if test='username != null'>",
                        "and username = #{username}",
                    "</if>",
                "</where>",
                "</script>"
    })
    List<User> selectUserByWhere (User user);

    /**
     * 查询用户
     * @param user  用户信息
     * @return  {@link List<User>}
     */
    List<User> selectUserByWhereWithXml (User user);
}
