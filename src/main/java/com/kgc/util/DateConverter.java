package com.kgc.util;


import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 实现自定义日期格式转换，格式为：yyyy-MM-dd
 * 
 * 	
 * 为何在springmvc-servlet.xml中配置不起作用，直接controller中声明起作用
	<!-- 拦截器 -->
	<bean id="annotationMethodHandlerAdapter" class="org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter">
		<!-- 日期格式转换 -->
        <property name="webBindingInitializer">
         <bean class="cn.itcast.jk.util.DateConverter"/>
        </property>
	</bean>
	
	
 */
public class DateConverter implements Converter<String,Date> {
	public Date convert(String source) {
		// 判断
		if(source == null){
			throw new RuntimeException("请您传入数据");
		}
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		try {
			// 把字符串转换日期
			return df.parse(source);
		} catch (Exception e) {
			throw new RuntimeException("数据类型转换出现错误");
		}
	}
}
