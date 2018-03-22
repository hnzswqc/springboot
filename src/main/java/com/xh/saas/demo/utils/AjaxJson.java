package com.xh.saas.demo.utils;

/**
 * $.ajax后需要接受的JSON
 * 
 * @author
 * 
 */
public class AjaxJson {

	/**
	 * 默认构造函数
	 */
	public AjaxJson(){}
	
	/**
	 * 带操作状态构造函数
	 * @param success
	 */
	public AjaxJson(boolean success){
		this.success = success;
	}
	
	/**
	 * 带操作状态、返回数据的构造函数
	 * @param success
	 * @param data
	 */
	public AjaxJson(boolean success,Object data){
		this.success = success;
		this.data = data;
	}
	/**
	 * 带操作状态、返回数据的构造函数
	 * @param success
	 * @param data
	 */
	public AjaxJson(boolean success,String msg){
		this.success = success;
		this.msg = msg;
	}
	
	/**
	 * 带操作状态、返回数据的构造函数
	 * @param success
	 * @param data
	 */
	public AjaxJson(boolean success,Object data,String msg){
		this.success = success;
		this.data = data;
		this.msg = msg;
	}
	
	private boolean success = true;// 是否成功
	
	private String msg = "操作成功";// 提示信息
	
	private Object data = null;// 其他信息
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
//	public String getJsonStr(){
//		JSONObject obj = new JSONObject();
//		obj.put("success", this.isSuccess());
//		obj.put("msg", this.getMsg());
//		obj.put("obj", this.obj);
//		obj.put("attributes", this.attributes);
//		return obj.toJSONString();
//	}
}
