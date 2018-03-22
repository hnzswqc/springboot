package com.xh.saas.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xh.saas.demo.model.User;
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> selectAllUser();
}