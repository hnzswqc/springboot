/*
 * 项目名称: springmvc
 * 文件 名称: IUservice.java
 * 创建时间: 2018年3月21日 上午8:45:41  
 * 版本号:  V1.0
 * 开发单位: 北京学汇教育科技股份公司-研发部
 */
package com.xh.saas.demo.service;

import java.util.List;

import com.core.base.service.IBaseService;
import com.xh.saas.demo.model.User;

/**    
 * 项目名称: springmvc <br/>
 * 文件名称: IUservice.java <br/>
 * 描述信息:   <br/>
 * 版本号: 1.0 <br/>
 * @author King  <br/>
 * @createTime 2018年3月21日 上午8:45:41 <br/>
 */
public interface IUservice extends IBaseService<User, Integer>{

	/**
	 * 
	 * 方法描述: 自定义方法<br/> 
	 * @param <br/>   
	 * @return <br/>   
	 * @version   1.0<br/> 
	 * @author King   <br/>  
	 * @createTime 2018年3月23日 下午1:05:21<br/>
	 */
    List<User> findAllUser(int pageNum, int pageSize);
    
}
