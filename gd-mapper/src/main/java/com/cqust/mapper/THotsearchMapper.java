package com.cqust.mapper;

import com.cqust.pojo.THotsearch;
import com.cqust.pojo.THotsearchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface THotsearchMapper {
    int countByExample(THotsearchExample example);

    int deleteByExample(THotsearchExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(THotsearch record);

    int insertSelective(THotsearch record);

    List<THotsearch> selectByExample(THotsearchExample example);

    THotsearch selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") THotsearch record, @Param("example") THotsearchExample example);

    int updateByExample(@Param("record") THotsearch record, @Param("example") THotsearchExample example);

    int updateByPrimaryKeySelective(THotsearch record);

    int updateByPrimaryKey(THotsearch record);
}