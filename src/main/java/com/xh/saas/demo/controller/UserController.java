/*
 * 项目名称: springmvc
 * 文件 名称: UserController.java
 * 创建时间: 2018年3月21日 上午8:44:50  
 * 版本号:  V1.0
 * 开发单位: 北京学汇教育科技股份公司-研发部
 */
package com.xh.saas.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.core.base.annotation.MyLog;
import com.core.base.controller.impl.BaseController;
import com.xh.saas.demo.model.User;
import com.xh.saas.demo.service.IUservice;
import com.core.base.model.AjaxJson;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**    
 * 项目名称: springmvc <br/>
 * 文件名称: UserController.java <br/>
 * 描述信息:   <br/>
 * 版本号: 1.0 <br/>
 * @author King  <br/>
 * @createTime 2018年3月21日 上午8:44:50 <br/>
 */
@Api(value = "UserController", description = "用户管理", tags = "基础平台")
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController<User, Integer>{
	
	@Autowired
    private IUservice userService = null;
	
	/**
	 * 
	 * 方法描述：信息注入<br/>
	 * 创建人：King   <br/>
	 * 创建时间：2016-10-9 上午11:31:58<br/>         
	 * @param <br/>   
	 * @return <br/>   
	 * @version   1.0<br/>
	 */
	@Autowired
	public void setBaseService() {
		super.setBaseService(userService);
	}
	
	
	public final String MODEL_NAME="用户管理模块";
	
	@ApiOperation(value = "添加用户")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType="query",name="userId",dataType="int",required=true,value="用户Id"),
        @ApiImplicitParam(paramType="query",name="userName",dataType="String",required=true,value="用户姓名"),
        @ApiImplicitParam(paramType="query",name="password",dataType="String",required=true,value="用户密码"),
        @ApiImplicitParam(paramType="query",name="phone",dataType="String",required=true,value="电话")
    })
	@ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    public AjaxJson add(User user){
        return super.add(user);
    }

	@MyLog(key=MODEL_NAME,value="获取用户信息列表")
	@ApiOperation(value = "获取用户信息列表",notes="默认查询第一页前10条")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType="query",name="pageNum",dataType="int",required=false,value="当前页",defaultValue="1"),
        @ApiImplicitParam(paramType="query",name="pageSize",dataType="int",required=false,value="页面查询数量",defaultValue="10")
    })
    @ResponseBody
    @RequestMapping(value = "/all", produces = {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    public AjaxJson findAllUser(int pageNum,int pageSize){
        return new AjaxJson(true,userService.findAllUser(pageNum,pageSize));
    }
	
	@ApiOperation(value = "删除用户信息",notes="根据url的id来指定删除对象")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType="query",name="userId",dataType="int",required=true,value="用户Id")
    })
    @ResponseBody
	@RequestMapping(value="/delele",  produces = {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    public AjaxJson delele(Integer userId){
    	return super.delete(userId);
    }
    
	@ApiOperation(value = "修改用户")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType="query",name="userId",dataType="int",required=true,value="用户Id",defaultValue=""),
        @ApiImplicitParam(paramType="query",name="userName",dataType="String",required=true,value="用户姓名",defaultValue=""),
        @ApiImplicitParam(paramType="query",name="password",dataType="String",required=true,value="用户密码",defaultValue=""),
        @ApiImplicitParam(paramType="query",name="phone",dataType="String",required=true,value="电话",defaultValue="")
    })
    @ResponseBody
    @RequestMapping(value = "/update", produces = {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    public AjaxJson update(User user){
    	return super.updateByPrimaryKeySelective(user);
    }
    
	@ApiOperation(value = "获取用户信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType="query",name="userId",dataType="int",required=true,value="用户Id")
    })
    @ResponseBody
    @RequestMapping(value = "/get", produces = {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    public AjaxJson get(Integer userId){
    	return super.getByPrimaryKey(userId);
    }
	 
}
