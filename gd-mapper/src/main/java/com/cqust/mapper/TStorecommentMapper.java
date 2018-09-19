package com.cqust.mapper;

import com.cqust.pojo.TStorecomment;
import com.cqust.pojo.TStorecommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TStorecommentMapper {
    int countByExample(TStorecommentExample example);

    int deleteByExample(TStorecommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TStorecomment record);

    int insertSelective(TStorecomment record);

    List<TStorecomment> selectByExample(TStorecommentExample example);

    TStorecomment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TStorecomment record, @Param("example") TStorecommentExample example);

    int updateByExample(@Param("record") TStorecomment record, @Param("example") TStorecommentExample example);

    int updateByPrimaryKeySelective(TStorecomment record);

    int updateByPrimaryKey(TStorecomment record);
}