package com.cqust.mapper;

import com.cqust.pojo.TSeason;
import com.cqust.pojo.TSeasonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSeasonMapper {
    int countByExample(TSeasonExample example);

    int deleteByExample(TSeasonExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSeason record);

    int insertSelective(TSeason record);

    List<TSeason> selectByExample(TSeasonExample example);

    TSeason selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TSeason record, @Param("example") TSeasonExample example);

    int updateByExample(@Param("record") TSeason record, @Param("example") TSeasonExample example);

    int updateByPrimaryKeySelective(TSeason record);

    int updateByPrimaryKey(TSeason record);
}