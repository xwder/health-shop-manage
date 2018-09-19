package com.cqust.mapper;

import com.cqust.pojo.TZxbrowserecord;
import com.cqust.pojo.TZxbrowserecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TZxbrowserecordMapper {
    int countByExample(TZxbrowserecordExample example);

    int deleteByExample(TZxbrowserecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TZxbrowserecord record);

    int insertSelective(TZxbrowserecord record);

    List<TZxbrowserecord> selectByExample(TZxbrowserecordExample example);

    TZxbrowserecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TZxbrowserecord record, @Param("example") TZxbrowserecordExample example);

    int updateByExample(@Param("record") TZxbrowserecord record, @Param("example") TZxbrowserecordExample example);

    int updateByPrimaryKeySelective(TZxbrowserecord record);

    int updateByPrimaryKey(TZxbrowserecord record);
}