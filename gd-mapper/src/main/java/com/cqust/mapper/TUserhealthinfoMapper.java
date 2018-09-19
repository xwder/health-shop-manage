package com.cqust.mapper;

import com.cqust.pojo.TUserhealthinfo;
import com.cqust.pojo.TUserhealthinfoExample;
import com.cqust.pojo.TUserhealthinfoKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserhealthinfoMapper {
    int countByExample(TUserhealthinfoExample example);

    int deleteByExample(TUserhealthinfoExample example);

    int deleteByPrimaryKey(TUserhealthinfoKey key);

    int insert(TUserhealthinfo record);

    int insertSelective(TUserhealthinfo record);

    List<TUserhealthinfo> selectByExample(TUserhealthinfoExample example);

    TUserhealthinfo selectByPrimaryKey(TUserhealthinfoKey key);

    int updateByExampleSelective(@Param("record") TUserhealthinfo record, @Param("example") TUserhealthinfoExample example);

    int updateByExample(@Param("record") TUserhealthinfo record, @Param("example") TUserhealthinfoExample example);

    int updateByPrimaryKeySelective(TUserhealthinfo record);

    int updateByPrimaryKey(TUserhealthinfo record);
}