package com.controller;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.model.Photo;

@Controller
@RequestMapping("/image/upload.do")
public class ImageController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		return "image/image";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submit(Photo photo, HttpServletRequest request) {
		/*
			1. Photo DTO 타입으로 데이터 받기
			1.1 자동화: name 속성괎이 Photo 타입 클래스 memberfield명과 동일
			2. 내부적으로 public String submit(Photo photo)
			2.1 Photo photo = new Photo();
			2.2 자동 주입
			photo.setName("홍길동")
			photo.setAge(50);
			photo.setImage() >> 자동주입 안됨 >> 업로드한 파일명 >> 가공
			photo.setFile(CommonsMultipartFile file)
		 */
		//System.out.println(photo.toString());
		
		CommonsMultipartFile imagefile = photo.getFile();
		System.out.println("imagefile.name: " + imagefile.getName());
		System.out.println("imagefile.getContentType: " + imagefile.getContentType());
		System.out.println("imagefile.getOriginalFilename: " + imagefile.getOriginalFilename());
		System.out.println("imagefile.getBytes: " + imagefile.getBytes().length);
		
		photo.setImage(imagefile.getName());
		
		//cos.jar 자동 파일 업로드
		//실제 파일업로드는 구현(upload 업로드)
		String filename = imagefile.getOriginalFilename();
		String path = request.getServletContext().getRealPath("/upload");//배포된 서버 경로
		String fpath= path + "/" + filename;
		System.out.println(fpath);
		
		FileOutputStream fs = null;
		try {
			fs = new FileOutputStream(fpath);
			fs.write(imagefile.getBytes());
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				fs.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		//DB작업 .. 파일 업로드 완료
		return "image/image";
	}
}
