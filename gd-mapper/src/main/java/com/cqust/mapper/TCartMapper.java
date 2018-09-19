package com.cqust.mapper;

import com.cqust.pojo.TCart;
import com.cqust.pojo.TCartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCartMapper {
    int countByExample(TCartExample example);

    int deleteByExample(TCartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCart record);

    int insertSelective(TCart record);

    List<TCart> selectByExample(TCartExample example);

    TCart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCart record, @Param("example") TCartExample example);

    int updateByExample(@Param("record") TCart record, @Param("example") TCartExample example);

    int updateByPrimaryKeySelective(TCart record);

    int updateByPrimaryKey(TCart record);
}