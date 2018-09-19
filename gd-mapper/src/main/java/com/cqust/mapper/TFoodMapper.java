package com.cqust.mapper;

import com.cqust.pojo.TFood;
import com.cqust.pojo.TFoodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TFoodMapper {
    int countByExample(TFoodExample example);

    int deleteByExample(TFoodExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TFood record);

    int insertSelective(TFood record);

    List<TFood> selectByExample(TFoodExample example);

    TFood selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TFood record, @Param("example") TFoodExample example);

    int updateByExample(@Param("record") TFood record, @Param("example") TFoodExample example);

    int updateByPrimaryKeySelective(TFood record);

    int updateByPrimaryKey(TFood record);
}