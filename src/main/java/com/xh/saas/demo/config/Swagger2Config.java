/*
 * 项目名称: springmvc
 * 文件 名称: Swagger2Config.java
 * 创建时间: 2018年3月21日 下午3:39:01  
 * 版本号:  V1.0
 * 开发单位: 北京学汇教育科技股份公司-研发部
 */
package com.xh.saas.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**    
 * 项目名称: springmvc <br/>
 * 文件名称: Swagger2Config.java <br/>
 * 描述信息:   <br/>
 * 版本号: 1.0 <br/>
 * @author King  <br/>
 * @createTime 2018年3月21日 下午3:39:01 <br/>
 */
@EnableSwagger2
@Configuration
public class Swagger2Config extends WebMvcConfigurerAdapter{

	/**
     * 这个地方要重新注入一下资源文件，不然不会注入资源的，也没有注入requestHandlerMappping,相当于xml配置的
     *  <!--swagger资源配置-->
     *  <mvc:resources location="classpath:/META-INF/resources/" mapping="swagger-ui.html"/>
     *  <mvc:resources location="classpath:/META-INF/resources/webjars/" mapping="/webjars/**"/>
     * @param registry
     */
     @Override
     public void addResourceHandlers(ResourceHandlerRegistry registry) {
         /*registry.addResourceHandler("swagger-ui.html")
         .addResourceLocations("classpath:/META-INF/resources/");
         registry.addResourceHandler("/webjars/**")
          .addResourceLocations("classpath:/META-INF/resources/webjars/");*/
     }
     
    //可以注入多个doket，也就是多个版本的api，可以在看到有三个版本groupName不能是重复的，v1和v2是ant风格匹配，配置文件
    @Bean
    public Docket api() {
    	 return new Docket(DocumentationType.SWAGGER_2)
    			 .groupName("基础平台接口")  
                 .apiInfo(apiInfo())
                 .select()
                 //.apis(RequestHandlerSelectors.basePackage("com.xh.saas.demo.controller"))
//                 .apis(RequestHandlerSelectors.basePackage("com.zskj.iap.webcenter.controller"))
                 // 只对使用了ApiOperation这个注解的API接口生效
                 .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                 // PathSelectors.any()方法会将所有包体下的方法进行关联和映射   
                 .paths(PathSelectors.any())
                 .build();
    }


    //api接口作者相关信息
    private ApiInfo apiInfo() {
        Contact contact = new Contact("北京学汇教育股份公司", "www.ixuehui.cn", "wangqc@ixuehui.cn");
        ApiInfo apiInfo = new ApiInfoBuilder().title("学汇教育共享平台")
        										.description("接口文档")
        										.contact(contact)
        										.version("1.0").build();
        return apiInfo;
    }
}
