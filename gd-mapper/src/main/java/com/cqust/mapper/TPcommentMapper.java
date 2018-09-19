package com.cqust.mapper;

import com.cqust.pojo.TPcomment;
import com.cqust.pojo.TPcommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPcommentMapper {
    int countByExample(TPcommentExample example);

    int deleteByExample(TPcommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPcomment record);

    int insertSelective(TPcomment record);

    List<TPcomment> selectByExample(TPcommentExample example);

    TPcomment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPcomment record, @Param("example") TPcommentExample example);

    int updateByExample(@Param("record") TPcomment record, @Param("example") TPcommentExample example);

    int updateByPrimaryKeySelective(TPcomment record);

    int updateByPrimaryKey(TPcomment record);
}