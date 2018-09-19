package com.cqust.mapper;

import com.cqust.pojo.TItemcollocation;
import com.cqust.pojo.TItemcollocationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TItemcollocationMapper {
    int countByExample(TItemcollocationExample example);

    int deleteByExample(TItemcollocationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TItemcollocation record);

    int insertSelective(TItemcollocation record);

    List<TItemcollocation> selectByExample(TItemcollocationExample example);

    TItemcollocation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TItemcollocation record, @Param("example") TItemcollocationExample example);

    int updateByExample(@Param("record") TItemcollocation record, @Param("example") TItemcollocationExample example);

    int updateByPrimaryKeySelective(TItemcollocation record);

    int updateByPrimaryKey(TItemcollocation record);
}