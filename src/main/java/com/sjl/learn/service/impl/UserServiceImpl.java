package com.sjl.learn.service.impl;

import com.sjl.learn.dao.data.DbUserMapper;
import com.sjl.learn.domain.data.DbUser;
import com.sjl.learn.domain.data.DbUserExample;
import com.sjl.learn.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class.getName());
    @Autowired
    private DbUserMapper dbUserMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    //redis 注解
//    @Cacheable(value = "db_user")
    @Override
    public DbUser selectByPrimaryKey(Integer id) {
        return selectRedis(id);
    }

    /**
     * redis 获取
     * @param id
     * @return
     */
    private DbUser selectRedis(Integer id) {
        String key = String.format("user_" + id);
        ValueOperations<String, DbUser> operations = redisTemplate.opsForValue();
        DbUser dbUser;
        if (redisTemplate.hasKey(key)) {
            dbUser = operations.get(key);
        } else {
            dbUser = dbUserMapper.selectByPrimaryKey(id);
        }
        operations.set(key, dbUser);
        return dbUser;
    }

    @Override
    public DbUser selectByWhere(String username, String password) {
        DbUserExample dbUserExample = new DbUserExample();
        dbUserExample.createCriteria().andUsernameEqualTo(username)
                .andPasswordEqualTo(password);
        List<DbUser> list = dbUserMapper.selectByExample(dbUserExample);
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<DbUser> selectByExample() {
        return dbUserMapper.selectByExample(null);
    }

    @Override
    public int insert(DbUser userBean) {
        return dbUserMapper.insert(userBean);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        deleteRedis(id);
        return dbUserMapper.deleteByPrimaryKey(id);
    }
    //redis 注解
//    @CachePut(value = "db_user")
    @Override
    public int updateUser(DbUser userBean) {
        if (userBean != null) {
            deleteRedis(userBean.getId());
        }
        return dbUserMapper.updateByPrimaryKey(userBean);
    }

    /**
     * redis删除
     * @param id
     */
    private void deleteRedis(int id) {
        String key = String.format("user_" + id);
        if (redisTemplate.hasKey(key)) {
            redisTemplate.delete(key);
            logger.info("delete redis " + key);
        }
    }
}
