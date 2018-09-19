package com.cqust.mapper;

import com.cqust.pojo.TPlanindexbyself;
import com.cqust.pojo.TPlanindexbyselfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPlanindexbyselfMapper {
    int countByExample(TPlanindexbyselfExample example);

    int deleteByExample(TPlanindexbyselfExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPlanindexbyself record);

    int insertSelective(TPlanindexbyself record);

    List<TPlanindexbyself> selectByExample(TPlanindexbyselfExample example);

    TPlanindexbyself selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPlanindexbyself record, @Param("example") TPlanindexbyselfExample example);

    int updateByExample(@Param("record") TPlanindexbyself record, @Param("example") TPlanindexbyselfExample example);

    int updateByPrimaryKeySelective(TPlanindexbyself record);

    int updateByPrimaryKey(TPlanindexbyself record);
}