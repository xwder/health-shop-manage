package com.cqust.mapper;

import com.cqust.pojo.TSeasoninfor;
import com.cqust.pojo.TSeasoninforExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSeasoninforMapper {
    int countByExample(TSeasoninforExample example);

    int deleteByExample(TSeasoninforExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSeasoninfor record);

    int insertSelective(TSeasoninfor record);

    List<TSeasoninfor> selectByExample(TSeasoninforExample example);

    TSeasoninfor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TSeasoninfor record, @Param("example") TSeasoninforExample example);

    int updateByExample(@Param("record") TSeasoninfor record, @Param("example") TSeasoninforExample example);

    int updateByPrimaryKeySelective(TSeasoninfor record);

    int updateByPrimaryKey(TSeasoninfor record);
}