package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/*

 */
import org.springframework.web.servlet.ModelAndView;

import com.model.NewArticleCommand;
import com.service.ArticleService;
@Controller
@RequestMapping("/article/newArticle.do")
public class NewArticleController {
	
	private ArticleService articleservice;
	
	@Autowired
	public void setArticleservice(ArticleService articleservice) {
		this.articleservice = articleservice;
	}

	@RequestMapping(method=RequestMethod.GET)//화면 제공
	public String form() {
		
		return "article/newArticleForm";
	}
	/*
	//1.데이터를 받는 가장 전통적인 방법 >> submit*(HttpServletRequest request) >> 코드량 >> Spring 다른 방법
	@RequestMapping(method=RequestMethod.POST)//insert 처리
	public ModelAndView submit(HttpServletRequest request) {//함수의 return type String 이라면 view 주소라고 하자
		
		NewArticleCommand article = new NewArticleCommand();
		article.setParentId(Integer.parseInt(request.getParameter("parentId")));
		article.setTitle(request.getParameter("title"));
		article.setContent(request.getParameter("content"));
		
		//NewArticleController 가 service 필요
		this.articleservice.writeArticle(article);
		//처리 완료
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("newArticleCommand",article);
		mv.setViewName("article/newArticleSubmitted");
		
		return mv;
	}
	*/
	
	
	/*
	//2. Spring에서 parameter 를 DTO 객체로 받기
	//2.1 자동화 >> 전제 조건이 >> input 테그의 name="" 값이 DTO객체의 member field 명과 동일 해야한다
	@RequestMapping(method=RequestMethod.POST)//insert 처리
	public ModelAndView submit(NewArticleCommand command) {//함수의 return type String 이라면 view 주소라고 하자
		
		//1. 자동으로 DTO객체가 생성: NewArticleCommand article = new NewArticleCommand();
		//2. 넘어온 parameter값이 setter 통해서 자동 주입
		//3. NewArticleCommand 객체가 IOC 컨테이너 안에 자동 생성 >> id 값이 자동 생성 >> id= "newArticleCommand"
		
		
		//NewArticleController 가 service 필요
		this.articleservice.writeArticle(command);
		//처리 완료
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("newArticleCommand",command);
		mv.setViewName("article/newArticleSubmitted");
		
		return mv;
	}
	*/
	
	
	@RequestMapping(method=RequestMethod.POST)//insert 처리
	public String submit(@ModelAttribute("Articledata") NewArticleCommand command) { //함수의 return type String 이라면 view 주소라고 하자
		
		
		//NewArticleController 가 service 필요
		this.articleservice.writeArticle(command);
		//처리 완료
		//view 페이지가 데이터 어찌 받는가?
		//NewArticleCommand 객체가 IOC 컨테이너 안에 자동 생성 >> id 값이 자동 생성 >> id= "newArticleCommand"
		
		//자동 forward >> view에서 >> 객체이름을 무었으로 받는가? >> newArticleCommand (key) >> 자동 forward
		
		//forward key의 이름을 내가 정의 >> mv.addObject("내맘대로",command);
		return "article/newArticleSubmitted";
	}
	
	
	
	
	
	
	
	
	
	
}
