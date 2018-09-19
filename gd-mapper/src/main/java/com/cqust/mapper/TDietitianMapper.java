package com.cqust.mapper;

import com.cqust.pojo.TDietitian;
import com.cqust.pojo.TDietitianExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDietitianMapper {
    int countByExample(TDietitianExample example);

    int deleteByExample(TDietitianExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TDietitian record);

    int insertSelective(TDietitian record);

    List<TDietitian> selectByExample(TDietitianExample example);

    TDietitian selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TDietitian record, @Param("example") TDietitianExample example);

    int updateByExample(@Param("record") TDietitian record, @Param("example") TDietitianExample example);

    int updateByPrimaryKeySelective(TDietitian record);

    int updateByPrimaryKey(TDietitian record);
}