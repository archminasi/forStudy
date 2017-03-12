package org.zerock.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor extends HandlerInterceptorAdapter {
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
		
		System.out.println("포스트 핸들러 호출");
		
		Object result = modelAndView.getModel().get("result");
		
		if(result != null){
			System.out.println("널아님");
			request.getSession().setAttribute("result", result);
			response.sendRedirect("/doA");
		}
	}
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		
		System.out.println("프리 핸들러 호출");
		
		HandlerMethod method = (HandlerMethod) handler;
		Method methodsObj = method.getMethod();
		
		System.out.println("Bean :" + method.getBean());
		System.out.println("Method : " + methodsObj);
		return true;
	}
	
	
	

}
