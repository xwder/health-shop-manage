package com.cqust.mapper;

import com.cqust.pojo.TUncomment;
import com.cqust.pojo.TUncommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUncommentMapper {
    int countByExample(TUncommentExample example);

    int deleteByExample(TUncommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUncomment record);

    int insertSelective(TUncomment record);

    List<TUncomment> selectByExample(TUncommentExample example);

    TUncomment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUncomment record, @Param("example") TUncommentExample example);

    int updateByExample(@Param("record") TUncomment record, @Param("example") TUncommentExample example);

    int updateByPrimaryKeySelective(TUncomment record);

    int updateByPrimaryKey(TUncomment record);
}