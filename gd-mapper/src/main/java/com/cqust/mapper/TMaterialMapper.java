package com.cqust.mapper;

import com.cqust.pojo.TMaterial;
import com.cqust.pojo.TMaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TMaterialMapper {
    int countByExample(TMaterialExample example);

    int deleteByExample(TMaterialExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TMaterial record);

    int insertSelective(TMaterial record);

    List<TMaterial> selectByExample(TMaterialExample example);

    TMaterial selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TMaterial record, @Param("example") TMaterialExample example);

    int updateByExample(@Param("record") TMaterial record, @Param("example") TMaterialExample example);

    int updateByPrimaryKeySelective(TMaterial record);

    int updateByPrimaryKey(TMaterial record);
}