package com.lim.biz.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("com.lim.biz")// CommonExceptionhandler를 객체화해주는 @
public class CommonExpceptionHandler {
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView aException(Exception e) { //널포인트 익셉션
		ModelAndView mav = new ModelAndView(); //이동할 페이지에 넘겨줄 값이 있기 때무에 mav사용
		mav.addObject("exception",e);
		mav.setViewName("/error/error.jsp");
		return mav;
	}
	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView bException(Exception e) { // 수학적인 문제	
		ModelAndView mav = new ModelAndView(); 
		mav.addObject("exception",e);
		mav.setViewName("/error/error.jsp");
		return mav;
	}
	@ExceptionHandler(Exception.class)
	public ModelAndView cException(Exception e) {// 미확인 예외
		ModelAndView mav = new ModelAndView(); 
		mav.addObject("exception",e);
		mav.setViewName("/error/error.jsp");
		return mav;
	}
	
}
