package com.cqust.mapper;

import com.cqust.pojo.TZxtype;
import com.cqust.pojo.TZxtypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TZxtypeMapper {
    int countByExample(TZxtypeExample example);

    int deleteByExample(TZxtypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TZxtype record);

    int insertSelective(TZxtype record);

    List<TZxtype> selectByExample(TZxtypeExample example);

    TZxtype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TZxtype record, @Param("example") TZxtypeExample example);

    int updateByExample(@Param("record") TZxtype record, @Param("example") TZxtypeExample example);

    int updateByPrimaryKeySelective(TZxtype record);

    int updateByPrimaryKey(TZxtype record);
}