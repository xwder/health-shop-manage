package com.cqust.mapper;

import com.cqust.pojo.TFoodnutrition;
import com.cqust.pojo.TFoodnutritionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TFoodnutritionMapper {
    int countByExample(TFoodnutritionExample example);

    int deleteByExample(TFoodnutritionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TFoodnutrition record);

    int insertSelective(TFoodnutrition record);

    List<TFoodnutrition> selectByExample(TFoodnutritionExample example);

    TFoodnutrition selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TFoodnutrition record, @Param("example") TFoodnutritionExample example);

    int updateByExample(@Param("record") TFoodnutrition record, @Param("example") TFoodnutritionExample example);

    int updateByPrimaryKeySelective(TFoodnutrition record);

    int updateByPrimaryKey(TFoodnutrition record);
}