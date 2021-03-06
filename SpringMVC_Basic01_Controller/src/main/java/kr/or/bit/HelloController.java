package kr.or.bit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller{

	public HelloController() {
		System.out.println("HelloController 객체 생성");
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("HelloController요청 실행: HandleRequest 함수 실행");
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("name","bituser");//request.setAttribute("name","bituser")
		mav.setViewName("Hello");
		//InternalResourceViewResolver에 의해서 view 단의 주소가 조합
		// /WEB-INF/views/ + Hello + .jsp >> /WEB-INF/views/Hello.jsp
		//mav.setViewName("/WEB-INF/views/Hello.jsp")
		return mav;
	}

}
