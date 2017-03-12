package org.zerock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */

@ControllerAdvice
public class CommonExceptionAdvice {
	
	
	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
	
	@ExceptionHandler(Exception.class)
	private ModelAndView errorModelAndView(Exception e){
		
		
		logger.info("에러캐치");
		ModelAndView modelANdView = new ModelAndView();
		modelANdView.setViewName("/error_common");
		modelANdView.addObject("exception", e);
		
		return modelANdView;
		
	}
	
	
}
