package com.cqust.mapper;

import com.cqust.pojo.TUserlog;
import com.cqust.pojo.TUserlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserlogMapper {
    int countByExample(TUserlogExample example);

    int deleteByExample(TUserlogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUserlog record);

    int insertSelective(TUserlog record);

    List<TUserlog> selectByExample(TUserlogExample example);

    TUserlog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUserlog record, @Param("example") TUserlogExample example);

    int updateByExample(@Param("record") TUserlog record, @Param("example") TUserlogExample example);

    int updateByPrimaryKeySelective(TUserlog record);

    int updateByPrimaryKey(TUserlog record);
}