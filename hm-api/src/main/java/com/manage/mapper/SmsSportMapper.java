package com.manage.mapper;

import com.manage.model.SmsSport;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 吴政杰
 */
@Mapper
public interface SmsSportMapper {

    /**
     * 在更新运动分类名称时更新运动列表的名称
     * @param smsSport
     */
    void updateSport(SmsSport smsSport);

    List<SmsSport> selectBySport(SmsSport smsSport);

    SmsSport selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsSport smsSport);

    int updateStatusByIds(Integer recommendStatus, List<Long> ids);

    void insertSelective(SmsSport smsSport);

    int deleteByIds(List<Long> ids);
}
