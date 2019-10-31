package com.zz80z.busAward.common.dao;

import com.zz80z.busAward.common.model.BRecord;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BRecordMapper {

    int countByExample(BRecord example);

    int deleteByExample(BRecord example);

    int deleteByPrimaryKey(Integer id);
 
    int insert(BRecord record);
   
    int insertSelective(BRecord record);
   
    List<BRecord> selectByExample(BRecord example);

    BRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BRecord record, @Param("example") BRecord example);
  
    int updateByExample(@Param("record") BRecord record, @Param("example") BRecord example);
   
    int updateByPrimaryKeySelective(BRecord record);

    int updateByPrimaryKey(BRecord record);
}