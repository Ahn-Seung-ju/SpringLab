package com.service;

import com.model.NewArticleCommand;



/*
 * @Service
 * public class ArticleService
 * 
 * xml 상단에
 * <context:component-scan base-package="com.sevice"
 */

public class ArticleService {
	
	public ArticleService() {
		System.out.println("ArticleService 생성자 호출");
	}
	
	public void writeArticle(NewArticleCommand command) {
		//DAO 있다고 가정
		//insert 실행 되었다고 가정
		System.out.println("글쓰기 작업 완료:" + command.toString());
	}
}
