package com.cqust.mapper;

import com.cqust.pojo.TSearchrecord;
import com.cqust.pojo.TSearchrecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSearchrecordMapper {
    int countByExample(TSearchrecordExample example);

    int deleteByExample(TSearchrecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TSearchrecord record);

    int insertSelective(TSearchrecord record);

    List<TSearchrecord> selectByExample(TSearchrecordExample example);

    TSearchrecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TSearchrecord record, @Param("example") TSearchrecordExample example);

    int updateByExample(@Param("record") TSearchrecord record, @Param("example") TSearchrecordExample example);

    int updateByPrimaryKeySelective(TSearchrecord record);

    int updateByPrimaryKey(TSearchrecord record);
}