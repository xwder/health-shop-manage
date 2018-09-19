package com.cqust.mapper;

import com.cqust.pojo.TDietplanbyself;
import com.cqust.pojo.TDietplanbyselfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDietplanbyselfMapper {
    int countByExample(TDietplanbyselfExample example);

    int deleteByExample(TDietplanbyselfExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TDietplanbyself record);

    int insertSelective(TDietplanbyself record);

    List<TDietplanbyself> selectByExample(TDietplanbyselfExample example);

    TDietplanbyself selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TDietplanbyself record, @Param("example") TDietplanbyselfExample example);

    int updateByExample(@Param("record") TDietplanbyself record, @Param("example") TDietplanbyselfExample example);

    int updateByPrimaryKeySelective(TDietplanbyself record);

    int updateByPrimaryKey(TDietplanbyself record);
}