package com.dailydatahub.dailydatahub.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.dailydatahub.dailydatahub.interceptor.CommonInterceptor;


@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
    public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CommonInterceptor())
				.addPathPatterns("/**")
				.excludePathPatterns();
	}
}