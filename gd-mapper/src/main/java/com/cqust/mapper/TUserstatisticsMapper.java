package com.cqust.mapper;

import com.cqust.pojo.TUserstatistics;
import com.cqust.pojo.TUserstatisticsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserstatisticsMapper {
    int countByExample(TUserstatisticsExample example);

    int deleteByExample(TUserstatisticsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUserstatistics record);

    int insertSelective(TUserstatistics record);

    List<TUserstatistics> selectByExample(TUserstatisticsExample example);

    TUserstatistics selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUserstatistics record, @Param("example") TUserstatisticsExample example);

    int updateByExample(@Param("record") TUserstatistics record, @Param("example") TUserstatisticsExample example);

    int updateByPrimaryKeySelective(TUserstatistics record);

    int updateByPrimaryKey(TUserstatistics record);
}