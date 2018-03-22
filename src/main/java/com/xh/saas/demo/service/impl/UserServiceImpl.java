/*
 * 项目名称: springmvc
 * 文件 名称: UserServiceImpl.java
 * 创建时间: 2018年3月21日 上午8:48:09  
 * 版本号:  V1.0
 * 开发单位: 北京学汇教育科技股份公司-研发部
 */
package com.xh.saas.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.xh.saas.demo.aop.MyLog;
import com.xh.saas.demo.mapper.UserMapper;
import com.xh.saas.demo.model.User;
import com.xh.saas.demo.service.IUservice;

/**    
 * 项目名称: springmvc <br/>
 * 文件名称: UserServiceImpl.java <br/>
 * 描述信息:   <br/>
 * 版本号: 1.0 <br/>
 * @author King  <br/>
 * @createTime 2018年3月21日 上午8:48:09 <br/>
 */
@Service
public class UserServiceImpl implements IUservice{

	
	@Autowired
	private UserMapper userMapper = null;
	
	/* (non-Javadoc)
	 * @see com.xh.saas.demo.service.IUservice#deleteByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public boolean deleteByPrimaryKey(Integer userId) {
		int result = userMapper.deleteByPrimaryKey(userId);
		return result>0?true:false;
	}

	/* (non-Javadoc)
	 * @see com.xh.saas.demo.service.IUservice#insert(com.xh.saas.demo.model.User)
	 */
	@Override
	public boolean insert(User record) {
		int result = userMapper.insert(record);
		return result>0?true:false;
	}

	/* (non-Javadoc)
	 * @see com.xh.saas.demo.service.IUservice#insertSelective(com.xh.saas.demo.model.User)
	 */
	@Override
	public boolean insertSelective(User record) {
		int result = userMapper.insertSelective(record);
		return result>0?true:false;
	}

	/* (non-Javadoc)
	 * @see com.xh.saas.demo.service.IUservice#selectByPrimaryKey(java.lang.Integer)
	 */
	@Override
	public User selectByPrimaryKey(Integer userId) {
		User user = userMapper.selectByPrimaryKey(userId);
		return user;
	}

	/* (non-Javadoc)
	 * @see com.xh.saas.demo.service.IUservice#updateByPrimaryKeySelective(com.xh.saas.demo.model.User)
	 */
	@Override
	public boolean updateByPrimaryKeySelective(User record) {
		int result = userMapper.updateByPrimaryKey(record);
		return result>0?true:false;
	}

	/* (non-Javadoc)
	 * @see com.xh.saas.demo.service.IUservice#updateByPrimaryKey(com.xh.saas.demo.model.User)
	 */
	@Override
	public boolean updateByPrimaryKey(User record) {
		int result = userMapper.updateByPrimaryKey(record);
		return result>0?true:false;
	}

	/* (non-Javadoc)
	 * @see com.xh.saas.demo.service.IUservice#findAllUser(int, int)
	 */
	@Override
	@MyLog(model="业务层",operate="获取用户信息列表")
	public List<User> findAllUser(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return userMapper.selectAllUser();
	}

}
