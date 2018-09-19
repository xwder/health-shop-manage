package com.cqust.mapper;

import com.cqust.pojo.TContent;
import com.cqust.pojo.TContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TContentMapper {
    int countByExample(TContentExample example);

    int deleteByExample(TContentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TContent record);

    int insertSelective(TContent record);

    List<TContent> selectByExample(TContentExample example);

    TContent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TContent record, @Param("example") TContentExample example);

    int updateByExample(@Param("record") TContent record, @Param("example") TContentExample example);

    int updateByPrimaryKeySelective(TContent record);

    int updateByPrimaryKey(TContent record);
}