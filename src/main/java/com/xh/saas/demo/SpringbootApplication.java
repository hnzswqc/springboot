/*
 * 项目名称: springmvc
 * 文件 名称: SpringbootApplication.java
 * 创建时间: 2018年3月21日 上午8:43:09  
 * 版本号:  V1.0
 * 开发单位: 北京学汇教育科技股份公司-研发部
 */
package com.xh.saas.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**    
 * 项目名称: springmvc <br/>
 * 文件名称: SpringbootApplication.java <br/>
 * 描述信息:   <br/>
 * 版本号: 1.0 <br/>
 * @author King  <br/>
 * @createTime 2018年3月21日 上午8:43:09 <br/>
 */
@SpringBootApplication
@MapperScan("com.xh.saas.demo.mapper")//将项目中对应的mapper类的路径加进来就可以了
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
