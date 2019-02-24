package com.sjl.learn.dao.data;

import com.sjl.learn.domain.data.DbUser;
import com.sjl.learn.domain.data.DbUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface DbUserMapper {
    int countByExample(DbUserExample example);

    int deleteByExample(DbUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DbUser record);

    int insertSelective(DbUser record);

    List<DbUser> selectByExample(DbUserExample example);

    DbUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DbUser record, @Param("example") DbUserExample example);

    int updateByExample(@Param("record") DbUser record, @Param("example") DbUserExample example);

    int updateByPrimaryKeySelective(DbUser record);

    int updateByPrimaryKey(DbUser record);
}