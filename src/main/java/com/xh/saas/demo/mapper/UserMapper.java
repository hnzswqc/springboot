package com.xh.saas.demo.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.core.base.mapper.BaseMapper;
import com.xh.saas.demo.model.User;
@Repository
public interface UserMapper extends BaseMapper<User, Integer>{

	/**
	 * 
	 * 方法描述:自定义方法 <br/> 
	 * @param <br/>   
	 * @return <br/>   
	 * @version   1.0<br/> 
	 * @author King   <br/>  
	 * @createTime 2018年3月23日 下午1:04:09<br/>
	 */
    List<User> selectAllUser();
}