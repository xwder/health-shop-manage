package com.cqust.mapper;

import com.cqust.pojo.TStoretype;
import com.cqust.pojo.TStoretypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TStoretypeMapper {
    int countByExample(TStoretypeExample example);

    int deleteByExample(TStoretypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TStoretype record);

    int insertSelective(TStoretype record);

    List<TStoretype> selectByExample(TStoretypeExample example);

    TStoretype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TStoretype record, @Param("example") TStoretypeExample example);

    int updateByExample(@Param("record") TStoretype record, @Param("example") TStoretypeExample example);

    int updateByPrimaryKeySelective(TStoretype record);

    int updateByPrimaryKey(TStoretype record);
}