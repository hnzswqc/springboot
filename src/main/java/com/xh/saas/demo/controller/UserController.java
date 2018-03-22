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

import com.xh.saas.demo.aop.MyLog;
import com.xh.saas.demo.model.User;
import com.xh.saas.demo.service.IUservice;
import com.xh.saas.demo.utils.AjaxJson;

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
public class UserController {
	
	@Autowired
    private IUservice userService = null;
	
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
		boolean result = userService.insert(user);
        return new AjaxJson(result?true:false,user);
    }

	@MyLog(model=MODEL_NAME,operate="获取用户信息列表")
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
	@RequestMapping(value="/del",  produces = {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    public AjaxJson del(Integer userId){
		boolean result = userService.deleteByPrimaryKey(userId);
    	return new AjaxJson(result?true:false,userId);
    }
    
	@ApiOperation(value = "修改用户")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType="query",name="userId",dataType="int",required=true,value="用户Id",defaultValue=""),
        @ApiImplicitParam(paramType="query",name="userName",dataType="String",required=true,value="用户姓名",defaultValue=""),
        @ApiImplicitParam(paramType="query",name="password",dataType="String",required=true,value="用户密码",defaultValue=""),
        @ApiImplicitParam(paramType="query",name="phone",dataType="String",required=true,value="电话",defaultValue="")
    })
    @ResponseBody
    @RequestMapping(value = "/upd", produces = {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    public AjaxJson upd(User user){
		boolean result = userService.updateByPrimaryKey(user);
    	return new AjaxJson(result?true:false,user);
    }
    
	@ApiOperation(value = "获取用户信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType="query",name="userId",dataType="int",required=true,value="用户Id")
    })
    @ResponseBody
    @RequestMapping(value = "/get", produces = {"application/json;charset=UTF-8"},method=RequestMethod.POST)
    public AjaxJson get(Integer userId){
    	return new AjaxJson(true,userService.selectByPrimaryKey(userId));
    }
	 
}
