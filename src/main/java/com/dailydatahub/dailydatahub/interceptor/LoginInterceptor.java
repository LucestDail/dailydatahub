package com.dailydatahub.dailydatahub.interceptor;

import java.util.Objects;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dailydatahub.dailydatahub.domain.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("deprecation")
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("(" +request.getRemoteAddr() + " : " + request.getRemotePort()+ ") => " + request.getRequestURI() + " / Thread [" + Thread.currentThread().getId() + "] -> " +Thread.currentThread().getStackTrace()[1].getClassName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("(" +request.getRemoteAddr() + " : " + request.getRemotePort()+ ") => " + request.getRequestURI() + " / Thread [" + Thread.currentThread().getId() + "] -> " +super.getClass().getCanonicalName() + " : crash");
		try{
			User sessionUser = (User) request.getSession().getAttribute("user");
			if(Objects.isNull(sessionUser)) {
				modelAndView.setViewName("main/login.html");
			}
		}catch(Exception e){
			//e.printStackTrace();
		}
	}
}