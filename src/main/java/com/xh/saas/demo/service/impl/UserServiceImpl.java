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

import com.core.base.annotation.MyLog;
import com.core.base.service.impl.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
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
public class UserServiceImpl extends BaseServiceImpl<User, Integer>implements IUservice{

	@Autowired
	private UserMapper userMapper = null;
	
	@Autowired
	public void setBaseMapper(){
		this.baseMapper = userMapper;
	}
	
	/* (non-Javadoc)
	 * @see com.xh.saas.demo.service.IUservice#findAllUser(int, int)
	 */
	@Override
	@MyLog(key="业务层",value="获取用户信息列表")
	public List<User> findAllUser(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		return userMapper.selectAllUser();
	}

}
