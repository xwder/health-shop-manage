package com.cqust.mapper;

import com.cqust.pojo.TPotalbrowserecord;
import com.cqust.pojo.TPotalbrowserecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPotalbrowserecordMapper {
    int countByExample(TPotalbrowserecordExample example);

    int deleteByExample(TPotalbrowserecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPotalbrowserecord record);

    int insertSelective(TPotalbrowserecord record);

    List<TPotalbrowserecord> selectByExample(TPotalbrowserecordExample example);

    TPotalbrowserecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPotalbrowserecord record, @Param("example") TPotalbrowserecordExample example);

    int updateByExample(@Param("record") TPotalbrowserecord record, @Param("example") TPotalbrowserecordExample example);

    int updateByPrimaryKeySelective(TPotalbrowserecord record);

    int updateByPrimaryKey(TPotalbrowserecord record);
}