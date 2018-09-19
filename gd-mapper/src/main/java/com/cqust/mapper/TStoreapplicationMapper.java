package com.cqust.mapper;

import com.cqust.pojo.TStoreapplication;
import com.cqust.pojo.TStoreapplicationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TStoreapplicationMapper {
    int countByExample(TStoreapplicationExample example);

    int deleteByExample(TStoreapplicationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TStoreapplication record);

    int insertSelective(TStoreapplication record);

    List<TStoreapplication> selectByExample(TStoreapplicationExample example);

    TStoreapplication selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TStoreapplication record, @Param("example") TStoreapplicationExample example);

    int updateByExample(@Param("record") TStoreapplication record, @Param("example") TStoreapplicationExample example);

    int updateByPrimaryKeySelective(TStoreapplication record);

    int updateByPrimaryKey(TStoreapplication record);
}