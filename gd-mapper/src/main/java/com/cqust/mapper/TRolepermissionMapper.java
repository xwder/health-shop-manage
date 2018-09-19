package com.cqust.mapper;

import com.cqust.pojo.TRolepermission;
import com.cqust.pojo.TRolepermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRolepermissionMapper {
    int countByExample(TRolepermissionExample example);

    int deleteByExample(TRolepermissionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TRolepermission record);

    int insertSelective(TRolepermission record);

    List<TRolepermission> selectByExample(TRolepermissionExample example);

    TRolepermission selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TRolepermission record, @Param("example") TRolepermissionExample example);

    int updateByExample(@Param("record") TRolepermission record, @Param("example") TRolepermissionExample example);

    int updateByPrimaryKeySelective(TRolepermission record);

    int updateByPrimaryKey(TRolepermission record);
}