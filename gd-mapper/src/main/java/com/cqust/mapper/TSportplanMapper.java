package com.cqust.mapper;

import com.cqust.pojo.TSportplan;
import com.cqust.pojo.TSportplanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSportplanMapper {
    int countByExample(TSportplanExample example);

    int deleteByExample(TSportplanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSportplan record);

    int insertSelective(TSportplan record);

    List<TSportplan> selectByExample(TSportplanExample example);

    TSportplan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TSportplan record, @Param("example") TSportplanExample example);

    int updateByExample(@Param("record") TSportplan record, @Param("example") TSportplanExample example);

    int updateByPrimaryKeySelective(TSportplan record);

    int updateByPrimaryKey(TSportplan record);
}