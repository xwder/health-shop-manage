package com.cqust.mapper;

import com.cqust.pojo.TUsersportsplan;
import com.cqust.pojo.TUsersportsplanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUsersportsplanMapper {
    int countByExample(TUsersportsplanExample example);

    int deleteByExample(TUsersportsplanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUsersportsplan record);

    int insertSelective(TUsersportsplan record);

    List<TUsersportsplan> selectByExample(TUsersportsplanExample example);

    TUsersportsplan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUsersportsplan record, @Param("example") TUsersportsplanExample example);

    int updateByExample(@Param("record") TUsersportsplan record, @Param("example") TUsersportsplanExample example);

    int updateByPrimaryKeySelective(TUsersportsplan record);

    int updateByPrimaryKey(TUsersportsplan record);
}