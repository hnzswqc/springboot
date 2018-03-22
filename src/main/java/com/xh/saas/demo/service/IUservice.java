/*
 * 项目名称: springmvc
 * 文件 名称: IUservice.java
 * 创建时间: 2018年3月21日 上午8:45:41  
 * 版本号:  V1.0
 * 开发单位: 北京学汇教育科技股份公司-研发部
 */
package com.xh.saas.demo.service;

import java.util.List;

import com.xh.saas.demo.model.User;

/**    
 * 项目名称: springmvc <br/>
 * 文件名称: IUservice.java <br/>
 * 描述信息:   <br/>
 * 版本号: 1.0 <br/>
 * @author King  <br/>
 * @createTime 2018年3月21日 上午8:45:41 <br/>
 */
public interface IUservice {

 	boolean deleteByPrimaryKey(Integer userId);

 	boolean insert(User record);

 	boolean insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    boolean updateByPrimaryKeySelective(User record);

    boolean updateByPrimaryKey(User record);
    
    List<User> findAllUser(int pageNum, int pageSize);
    
}
