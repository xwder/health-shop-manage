package com.cqust.mapper;

import com.cqust.pojo.TPlanindex;
import com.cqust.pojo.TPlanindexExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPlanindexMapper {
    int countByExample(TPlanindexExample example);

    int deleteByExample(TPlanindexExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPlanindex record);

    int insertSelective(TPlanindex record);

    List<TPlanindex> selectByExample(TPlanindexExample example);

    TPlanindex selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPlanindex record, @Param("example") TPlanindexExample example);

    int updateByExample(@Param("record") TPlanindex record, @Param("example") TPlanindexExample example);

    int updateByPrimaryKeySelective(TPlanindex record);

    int updateByPrimaryKey(TPlanindex record);
}