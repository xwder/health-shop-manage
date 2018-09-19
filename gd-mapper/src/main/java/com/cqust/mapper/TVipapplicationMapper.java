package com.cqust.mapper;

import com.cqust.pojo.TVipapplication;
import com.cqust.pojo.TVipapplicationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TVipapplicationMapper {
    int countByExample(TVipapplicationExample example);

    int deleteByExample(TVipapplicationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TVipapplication record);

    int insertSelective(TVipapplication record);

    List<TVipapplication> selectByExample(TVipapplicationExample example);

    TVipapplication selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TVipapplication record, @Param("example") TVipapplicationExample example);

    int updateByExample(@Param("record") TVipapplication record, @Param("example") TVipapplicationExample example);

    int updateByPrimaryKeySelective(TVipapplication record);

    int updateByPrimaryKey(TVipapplication record);
}