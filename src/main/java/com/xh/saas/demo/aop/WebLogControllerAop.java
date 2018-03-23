/*
 * 项目名称: springmvc
 * 文件 名称: WebLogControllerAop.java
 * 创建时间: 2018年3月22日 下午2:09:53  
 * 版本号:  V1.0
 * 开发单位: 北京学汇教育科技股份公司-研发部
 */
package com.xh.saas.demo.aop;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.core.base.annotation.MyLog;

/**    
 * 项目名称: springmvc <br/>
 * 文件名称: WebLogControllerAop.java <br/>
 * 描述信息: 系统日志切面配置  <br/>
 * 版本号: 1.0 <br/>
 * @author King  <br/>
 * @createTime 2018年3月22日 下午2:09:53 <br/>
 */
@Component
@Aspect
public class WebLogControllerAop {

	/**
	 * 日志
	 */
	Logger log = Logger.getLogger(this.getClass());
	
	
	// 全系统层切点
	@Pointcut("execution ( * com.xh.saas.*.*.*.*(..))")
	public void aspect() { }
		
	/**
	 * 
	 * 方法描述: 匹配com.xh.saas.demo.controller包及其子包下的所有类的所有方法<br/> 
	 * @param <br/>   
	 * @return <br/>   
	 * @version   1.0<br/> 
	 * @author King   <br/>  
	 * @createTime 2018年3月22日 下午2:18:06<br/>
	 */
	@Pointcut("execution(* com.xh.saas.demo.controller.*.*(..))")
	public void controllerAspect(){
		log.info("controllerAspect....调用切面.......");
	}
	
	/**
	 * 
	 * 方法描述:service切点 <br/> 
	 * @param <br/>   
	 * @return <br/>   
	 * @version   1.0<br/> 
	 * @author King   <br/>  
	 * @createTime 2018年3月22日 下午2:27:24<br/>
	 */
	@Pointcut("execution(* com.xh.saas.demo.service.impl.*.*(..))")
	public void serviceAspect() { }
	
	/**
	 * 
	 * 方法描述: 前置通知<br/> 
	 * @param <br/>   
	 * @return <br/>   
	 * @version   1.0<br/> 
	 * @author King   <br/>  
	 * @createTime 2018年3月22日 下午2:43:37<br/>
	 */
	@SuppressWarnings("unused")
	@Before("controllerAspect()")
	public void doBeforeAdvice(JoinPoint joinPoint){
		System.out.println("我是前置通知!!!");
		//获取目标方法的参数信息  
		Object[] obj = joinPoint.getArgs();
		//AOP代理类的信息
		Object dlObj = joinPoint.getThis();
		//代理的目标对象
		joinPoint.getTarget();  
		//用的最多 通知的签名  
		Signature signature = joinPoint.getSignature();  
	    //代理的是哪一个方法  
	    System.out.println(signature.getName());  
	    //AOP代理类的名字  
	    System.out.println(signature.getDeclaringTypeName());  
	    //AOP代理类的类（class）信息  
	    signature.getDeclaringType();  
	    
	    //获取MyLog注解的信息
	    MethodSignature ms = (MethodSignature) joinPoint.getSignature();  
        //入参key  
        String[] parameterNames = ms.getParameterNames();  
        //入参value  
        Object[] arguments = joinPoint.getArgs();  
        Method method = ms.getMethod();  
        //方法的注解对象  
        MyLog myLog = method.getAnnotation(MyLog.class);
        if(null!=myLog){
        	System.out.println(myLog.key());
        	System.out.println(myLog.value());
        }
	    
	    
	    
	    
	    //获取RequestAttributes  
	    RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();  
	    //从获取RequestAttributes中获取HttpServletRequest的信息  
	    HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);  
	    //如果要获取Session信息的话，可以这样写：  
	    //HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);  
	    Enumeration<String> enumeration = request.getParameterNames();  
	    Map<String,String> parameterMap = new HashMap<String, String>();
	    while (enumeration.hasMoreElements()){  
	        String parameter = enumeration.nextElement();  
	        parameterMap.put(parameter,request.getParameter(parameter));  
	    }  
	    
	    
	    
	    System.out.println(System.currentTimeMillis());
  
        // 记录下请求内容  
        log.info("URL : " + request.getRequestURL().toString());  
        log.info("HTTP_METHOD : " + request.getMethod());  
        log.info("IP : " + request.getRemoteAddr());  
        log.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());  
        log.info("ARGS : " + Arrays.toString(joinPoint.getArgs())); 
	}
	
	
	
	/**
	 * 
	 * 方法描述: 后置通知，返回参数信息<br/> 
	 * @param <br/>   
	 * @return <br/>   
	 * @version   1.0<br/> 
	 * @author King   <br/>  
	 * @createTime 2018年3月22日 下午3:06:13<br/>
	 */
	@AfterReturning(returning = "keys", pointcut = "controllerAspect()")
	public void doAfterAdvice(Object keys){
		System.out.println("doAfterAdvice。。。。。执行");
	}
	
	/**
	 * 
	 * 方法描述: 错误通知，系统出现错误记录错误日志<br/> 
	 * @param <br/>   
	 * @return <br/>   
	 * @version   1.0<br/> 
	 * @author King   <br/>  
	 * @createTime 2018年3月22日 下午3:09:02<br/>
	 */
	@AfterThrowing(throwing = "err", pointcut = "aspect()")
	public void doAfterThr(JoinPoint joinPoint, Throwable err){
		System.out.println("出现错误信息:"+err.getMessage());
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
