package com.cqust.mapper;

import com.cqust.pojo.TSportsoption;
import com.cqust.pojo.TSportsoptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSportsoptionMapper {
    int countByExample(TSportsoptionExample example);

    int deleteByExample(TSportsoptionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSportsoption record);

    int insertSelective(TSportsoption record);

    List<TSportsoption> selectByExample(TSportsoptionExample example);

    TSportsoption selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TSportsoption record, @Param("example") TSportsoptionExample example);

    int updateByExample(@Param("record") TSportsoption record, @Param("example") TSportsoptionExample example);

    int updateByPrimaryKeySelective(TSportsoption record);

    int updateByPrimaryKey(TSportsoption record);
}