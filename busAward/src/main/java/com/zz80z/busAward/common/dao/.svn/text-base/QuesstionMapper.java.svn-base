package com.zz80z.busAward.common.dao;

import com.zz80z.busAward.common.model.Quesstion;
import com.zz80z.busAward.common.model.QuesstionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuesstionMapper {
    long countByExample(QuesstionExample example);

    int deleteByExample(QuesstionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Quesstion record);

    int insertSelective(Quesstion record);

    List<Quesstion> selectByExample(QuesstionExample example);

    Quesstion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Quesstion record, @Param("example") QuesstionExample example);

    int updateByExample(@Param("record") Quesstion record, @Param("example") QuesstionExample example);

    int updateByPrimaryKeySelective(Quesstion record);

    int updateByPrimaryKey(Quesstion record);

	List<Quesstion> selectByType(String type);
}