package com.sjl.learn.dao.base;

import com.sjl.learn.domain.base.DbUserType;
import com.sjl.learn.domain.base.DbUserTypeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
public interface DbUserTypeMapper {
    int countByExample(DbUserTypeExample example);

    int deleteByExample(DbUserTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DbUserType record);

    int insertSelective(DbUserType record);

    List<DbUserType> selectByExample(DbUserTypeExample example);

    DbUserType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DbUserType record, @Param("example") DbUserTypeExample example);

    int updateByExample(@Param("record") DbUserType record, @Param("example") DbUserTypeExample example);

    int updateByPrimaryKeySelective(DbUserType record);

    int updateByPrimaryKey(DbUserType record);
}