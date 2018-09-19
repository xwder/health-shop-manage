package com.cqust.mapper;

import com.cqust.pojo.TOrderitem;
import com.cqust.pojo.TOrderitemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TOrderitemMapper {
    int countByExample(TOrderitemExample example);

    int deleteByExample(TOrderitemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TOrderitem record);

    int insertSelective(TOrderitem record);

    List<TOrderitem> selectByExample(TOrderitemExample example);

    TOrderitem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TOrderitem record, @Param("example") TOrderitemExample example);

    int updateByExample(@Param("record") TOrderitem record, @Param("example") TOrderitemExample example);

    int updateByPrimaryKeySelective(TOrderitem record);

    int updateByPrimaryKey(TOrderitem record);
}