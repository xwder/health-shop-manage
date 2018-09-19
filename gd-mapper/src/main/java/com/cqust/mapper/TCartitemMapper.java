package com.cqust.mapper;

import com.cqust.pojo.TCartitem;
import com.cqust.pojo.TCartitemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCartitemMapper {
    int countByExample(TCartitemExample example);

    int deleteByExample(TCartitemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCartitem record);

    int insertSelective(TCartitem record);

    List<TCartitem> selectByExample(TCartitemExample example);

    TCartitem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCartitem record, @Param("example") TCartitemExample example);

    int updateByExample(@Param("record") TCartitem record, @Param("example") TCartitemExample example);

    int updateByPrimaryKeySelective(TCartitem record);

    int updateByPrimaryKey(TCartitem record);
}