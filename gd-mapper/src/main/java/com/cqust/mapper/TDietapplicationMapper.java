package com.cqust.mapper;

import com.cqust.pojo.TDietapplication;
import com.cqust.pojo.TDietapplicationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDietapplicationMapper {
    int countByExample(TDietapplicationExample example);

    int deleteByExample(TDietapplicationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TDietapplication record);

    int insertSelective(TDietapplication record);

    List<TDietapplication> selectByExample(TDietapplicationExample example);

    TDietapplication selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TDietapplication record, @Param("example") TDietapplicationExample example);

    int updateByExample(@Param("record") TDietapplication record, @Param("example") TDietapplicationExample example);

    int updateByPrimaryKeySelective(TDietapplication record);

    int updateByPrimaryKey(TDietapplication record);
}