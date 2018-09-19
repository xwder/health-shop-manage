package com.cqust.mapper;

import com.cqust.pojo.TUserdietplan;
import com.cqust.pojo.TUserdietplanExample;
import com.cqust.pojo.TUserdietplanWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserdietplanMapper {
    int countByExample(TUserdietplanExample example);

    int deleteByExample(TUserdietplanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUserdietplanWithBLOBs record);

    int insertSelective(TUserdietplanWithBLOBs record);

    List<TUserdietplanWithBLOBs> selectByExampleWithBLOBs(TUserdietplanExample example);

    List<TUserdietplan> selectByExample(TUserdietplanExample example);

    TUserdietplanWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUserdietplanWithBLOBs record, @Param("example") TUserdietplanExample example);

    int updateByExampleWithBLOBs(@Param("record") TUserdietplanWithBLOBs record, @Param("example") TUserdietplanExample example);

    int updateByExample(@Param("record") TUserdietplan record, @Param("example") TUserdietplanExample example);

    int updateByPrimaryKeySelective(TUserdietplanWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TUserdietplanWithBLOBs record);

    int updateByPrimaryKey(TUserdietplan record);
}