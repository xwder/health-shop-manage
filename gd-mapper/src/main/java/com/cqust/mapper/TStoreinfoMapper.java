package com.cqust.mapper;

import com.cqust.pojo.TStoreinfo;
import com.cqust.pojo.TStoreinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TStoreinfoMapper {
    int countByExample(TStoreinfoExample example);

    int deleteByExample(TStoreinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TStoreinfo record);

    int insertSelective(TStoreinfo record);

    List<TStoreinfo> selectByExample(TStoreinfoExample example);

    TStoreinfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TStoreinfo record, @Param("example") TStoreinfoExample example);

    int updateByExample(@Param("record") TStoreinfo record, @Param("example") TStoreinfoExample example);

    int updateByPrimaryKeySelective(TStoreinfo record);

    int updateByPrimaryKey(TStoreinfo record);
}