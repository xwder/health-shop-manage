package com.cqust.mapper;

import com.cqust.pojo.TZxinfo;
import com.cqust.pojo.TZxinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TZxinfoMapper {
    int countByExample(TZxinfoExample example);

    int deleteByExample(TZxinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TZxinfo record);

    int insertSelective(TZxinfo record);

    List<TZxinfo> selectByExampleWithBLOBs(TZxinfoExample example);

    List<TZxinfo> selectByExample(TZxinfoExample example);

    TZxinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TZxinfo record, @Param("example") TZxinfoExample example);

    int updateByExampleWithBLOBs(@Param("record") TZxinfo record, @Param("example") TZxinfoExample example);

    int updateByExample(@Param("record") TZxinfo record, @Param("example") TZxinfoExample example);

    int updateByPrimaryKeySelective(TZxinfo record);

    int updateByPrimaryKeyWithBLOBs(TZxinfo record);

    int updateByPrimaryKey(TZxinfo record);
}