package com.cqust.mapper;

import com.cqust.pojo.TMessageremind;
import com.cqust.pojo.TMessageremindExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMessageremindMapper {
    int countByExample(TMessageremindExample example);

    int deleteByExample(TMessageremindExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TMessageremind record);

    int insertSelective(TMessageremind record);

    List<TMessageremind> selectByExample(TMessageremindExample example);

    TMessageremind selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TMessageremind record, @Param("example") TMessageremindExample example);

    int updateByExample(@Param("record") TMessageremind record, @Param("example") TMessageremindExample example);

    int updateByPrimaryKeySelective(TMessageremind record);

    int updateByPrimaryKey(TMessageremind record);
}