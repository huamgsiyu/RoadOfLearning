package com.imooc.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
}
