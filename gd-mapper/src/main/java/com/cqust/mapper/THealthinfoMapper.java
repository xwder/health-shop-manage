package com.cqust.mapper;

import com.cqust.pojo.THealthinfo;
import com.cqust.pojo.THealthinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface THealthinfoMapper {
    int countByExample(THealthinfoExample example);

    int deleteByExample(THealthinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(THealthinfo record);

    int insertSelective(THealthinfo record);

    List<THealthinfo> selectByExampleWithBLOBs(THealthinfoExample example);

    List<THealthinfo> selectByExample(THealthinfoExample example);

    THealthinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") THealthinfo record, @Param("example") THealthinfoExample example);

    int updateByExampleWithBLOBs(@Param("record") THealthinfo record, @Param("example") THealthinfoExample example);

    int updateByExample(@Param("record") THealthinfo record, @Param("example") THealthinfoExample example);

    int updateByPrimaryKeySelective(THealthinfo record);

    int updateByPrimaryKeyWithBLOBs(THealthinfo record);

    int updateByPrimaryKey(THealthinfo record);
}