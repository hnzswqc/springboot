/*
 * 项目名称: springmvc
 * 文件 名称: MyLog.java
 * 创建时间: 2018年3月22日 下午3:15:55  
 * 版本号:  V1.0
 * 开发单位: 北京学汇教育科技股份公司-研发部
 */
package com.xh.saas.demo.log;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**    
 * 项目名称: springmvc <br/>
 * 文件名称: MyLog.java <br/>
 * 描述信息: 日志注解 <br/>
 * 版本号: 1.0 <br/>
 * @author King  <br/>
 * @createTime 2018年3月22日 下午3:15:55 <br/>
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})  
@Retention(RetentionPolicy.RUNTIME)  
@Documented
public @interface MyLog {
	/**
	 * 
	 * 方法描述: 日志发生模块<br/> 
	 * @param <br/>   
	 * @return <br/>   
	 * @version   1.0<br/> 
	 * @author King   <br/>  
	 * @createTime 2018年3月22日 下午3:20:35<br/>
	 */
    public String model() default "";
    
    /**
     * 
     * 方法描述: 日志操作内容<br/> 
     * @param <br/>   
     * @return <br/>   
     * @version   1.0<br/> 
     * @author King   <br/>  
     * @createTime 2018年3月22日 下午3:20:44<br/>
     */
    public String operate() default "";
    
    
    
}
