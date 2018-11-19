package com.howtodoinjava.demo.spring.config;


import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
 * https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-config-enable
 * */

// 配置入口 web.xml
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	// spring 注入 bean
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { HibernateConfig.class };
	}

	// spring mvc 配置
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebMvcConfig.class };
	}

	// 配置DispatcherServlet映射到 '/' 什么情况进入DispatherServlet
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	// 注册过滤器
	@Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[]{new HiddenHttpMethodFilter(), characterEncodingFilter};
    }

}
