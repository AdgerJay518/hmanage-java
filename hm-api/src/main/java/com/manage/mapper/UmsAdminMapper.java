package com.manage.mapper;

import com.manage.model.UmsAdmin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 吴政杰
 */
@Mapper
public interface UmsAdminMapper {
    /**
     * 根据用户名找到用户信息
     * @param username
     * @return
     */
    List<UmsAdmin> getAdminByUsername(String username);

    /**
     * 模糊查询
     * @param username
     * @return
     */
    List<UmsAdmin> getByLikeUsername(String username);

    /**
     * 根据id找到用户信息
     * @param id
     * @return
     */
    UmsAdmin selectByPrimaryKey(Long id);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 更新用户信息
     * @param admin
     * @return
     */
    int updateByPrimaryKeySelective(UmsAdmin admin);

    /**
     * 向数据库插入新用户信息
     * @param record
     * @return
     */
    int insert(UmsAdmin record);
}
