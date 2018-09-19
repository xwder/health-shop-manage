package com.cqust.mapper;

import com.cqust.pojo.TDietitioncomment;
import com.cqust.pojo.TDietitioncommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDietitioncommentMapper {
    int countByExample(TDietitioncommentExample example);

    int deleteByExample(TDietitioncommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TDietitioncomment record);

    int insertSelective(TDietitioncomment record);

    List<TDietitioncomment> selectByExample(TDietitioncommentExample example);

    TDietitioncomment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TDietitioncomment record, @Param("example") TDietitioncommentExample example);

    int updateByExample(@Param("record") TDietitioncomment record, @Param("example") TDietitioncommentExample example);

    int updateByPrimaryKeySelective(TDietitioncomment record);

    int updateByPrimaryKey(TDietitioncomment record);
}