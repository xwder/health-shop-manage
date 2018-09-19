package com.cqust.mapper;

import com.cqust.pojo.TStoretuisong;
import com.cqust.pojo.TStoretuisongExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TStoretuisongMapper {
    int countByExample(TStoretuisongExample example);

    int deleteByExample(TStoretuisongExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TStoretuisong record);

    int insertSelective(TStoretuisong record);

    List<TStoretuisong> selectByExample(TStoretuisongExample example);

    TStoretuisong selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TStoretuisong record, @Param("example") TStoretuisongExample example);

    int updateByExample(@Param("record") TStoretuisong record, @Param("example") TStoretuisongExample example);

    int updateByPrimaryKeySelective(TStoretuisong record);

    int updateByPrimaryKey(TStoretuisong record);
}