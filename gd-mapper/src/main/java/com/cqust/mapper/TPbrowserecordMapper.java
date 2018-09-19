package com.cqust.mapper;

import com.cqust.pojo.TPbrowserecord;
import com.cqust.pojo.TPbrowserecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPbrowserecordMapper {
    int countByExample(TPbrowserecordExample example);

    int deleteByExample(TPbrowserecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPbrowserecord record);

    int insertSelective(TPbrowserecord record);

    List<TPbrowserecord> selectByExample(TPbrowserecordExample example);

    TPbrowserecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPbrowserecord record, @Param("example") TPbrowserecordExample example);

    int updateByExample(@Param("record") TPbrowserecord record, @Param("example") TPbrowserecordExample example);

    int updateByPrimaryKeySelective(TPbrowserecord record);

    int updateByPrimaryKey(TPbrowserecord record);
}