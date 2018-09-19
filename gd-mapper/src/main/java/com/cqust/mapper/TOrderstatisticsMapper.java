package com.cqust.mapper;

import com.cqust.pojo.TOrderstatistics;
import com.cqust.pojo.TOrderstatisticsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TOrderstatisticsMapper {
    int countByExample(TOrderstatisticsExample example);

    int deleteByExample(TOrderstatisticsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TOrderstatistics record);

    int insertSelective(TOrderstatistics record);

    List<TOrderstatistics> selectByExample(TOrderstatisticsExample example);

    TOrderstatistics selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TOrderstatistics record, @Param("example") TOrderstatisticsExample example);

    int updateByExample(@Param("record") TOrderstatistics record, @Param("example") TOrderstatisticsExample example);

    int updateByPrimaryKeySelective(TOrderstatistics record);

    int updateByPrimaryKey(TOrderstatistics record);
}