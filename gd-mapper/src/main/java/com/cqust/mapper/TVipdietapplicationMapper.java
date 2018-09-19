package com.cqust.mapper;

import com.cqust.pojo.TVipdietapplication;
import com.cqust.pojo.TVipdietapplicationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TVipdietapplicationMapper {
    int countByExample(TVipdietapplicationExample example);

    int deleteByExample(TVipdietapplicationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TVipdietapplication record);

    int insertSelective(TVipdietapplication record);

    List<TVipdietapplication> selectByExample(TVipdietapplicationExample example);

    TVipdietapplication selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TVipdietapplication record, @Param("example") TVipdietapplicationExample example);

    int updateByExample(@Param("record") TVipdietapplication record, @Param("example") TVipdietapplicationExample example);

    int updateByPrimaryKeySelective(TVipdietapplication record);

    int updateByPrimaryKey(TVipdietapplication record);
}