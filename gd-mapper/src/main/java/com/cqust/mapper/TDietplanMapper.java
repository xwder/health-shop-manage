package com.cqust.mapper;

import com.cqust.pojo.TDietplan;
import com.cqust.pojo.TDietplanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDietplanMapper {
    int countByExample(TDietplanExample example);

    int deleteByExample(TDietplanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TDietplan record);

    int insertSelective(TDietplan record);

    List<TDietplan> selectByExample(TDietplanExample example);

    TDietplan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TDietplan record, @Param("example") TDietplanExample example);

    int updateByExample(@Param("record") TDietplan record, @Param("example") TDietplanExample example);

    int updateByPrimaryKeySelective(TDietplan record);

    int updateByPrimaryKey(TDietplan record);
}