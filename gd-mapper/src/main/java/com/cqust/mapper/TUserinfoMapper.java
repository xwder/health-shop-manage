package com.cqust.mapper;

import com.cqust.pojo.TUserinfo;
import com.cqust.pojo.TUserinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserinfoMapper {
    int countByExample(TUserinfoExample example);

    int deleteByExample(TUserinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUserinfo record);

    int insertSelective(TUserinfo record);

    List<TUserinfo> selectByExample(TUserinfoExample example);

    TUserinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUserinfo record, @Param("example") TUserinfoExample example);

    int updateByExample(@Param("record") TUserinfo record, @Param("example") TUserinfoExample example);

    int updateByPrimaryKeySelective(TUserinfo record);

    int updateByPrimaryKey(TUserinfo record);
}