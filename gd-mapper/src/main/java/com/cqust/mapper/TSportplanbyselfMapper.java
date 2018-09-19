package com.cqust.mapper;

import com.cqust.pojo.TSportplanbyself;
import com.cqust.pojo.TSportplanbyselfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSportplanbyselfMapper {
    int countByExample(TSportplanbyselfExample example);

    int deleteByExample(TSportplanbyselfExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSportplanbyself record);

    int insertSelective(TSportplanbyself record);

    List<TSportplanbyself> selectByExample(TSportplanbyselfExample example);

    TSportplanbyself selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TSportplanbyself record, @Param("example") TSportplanbyselfExample example);

    int updateByExample(@Param("record") TSportplanbyself record, @Param("example") TSportplanbyselfExample example);

    int updateByPrimaryKeySelective(TSportplanbyself record);

    int updateByPrimaryKey(TSportplanbyself record);
}