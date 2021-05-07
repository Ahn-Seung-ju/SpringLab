package ncontroller;

import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;


import dao.NoticeDao;
import vo.Notice;

@Controller
@RequestMapping("/customer/")
public class CustomerController {
	
	private NoticeDao noticedao;

	public NoticeDao getNoticedao() {
		return noticedao;
	}
	@Autowired
	public void setNoticedao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}
	
	/*
		1. method 안에서 return type [String] 리턴값이 뷰의 주소
		
		2. public ModelAndView noticeView >> ModelAndView 객체 생성 > 데이터 뷰 설정 > return
		
		3. public String noticeView(Model model){ 함수 실행시 내부적으로 Model객체의 주소가 들어온다 } 
	 */
	@RequestMapping("notice.htm")
	public String noticeView(@RequestParam(value = "pg", defaultValue = "1") String page, 
								   @RequestParam(value = "f", defaultValue = "TITLE") String field, 
								   @RequestParam(value = "p", defaultValue = "%%") String query,
								   Model model) {
		
		int _page = Integer.parseInt(page);
		
		//DAO 작업
		List<Notice> list = null;
		try {
			list = noticedao.getNotices(_page, field, query);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Spring 적용
		/*
		ModelAndView mv = new ModelAndView();
		mv.addObject("list",list);
		mv.setViewName("notice");
		*/
		
		model.addAttribute("list",list);//자동으로 notice.jsp forward
		
		/*
			<c:forEach items = "${list}" var = "list">
		 */
		return "notice";
		
		
	}
	@RequestMapping("noticeDetail.htm")
	public String noticeDetail(String seq, Model model) {
		
		
		Notice notice = null;
		try {
			notice = noticedao.getNotice(seq);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("notice",notice);
		
		
		return "noticeDetail";
	}
	
	//글쓰기 화면(GET)
	//http://localhost:8090/SpringMVC_Basic04_WebSite_Annotation/customer/notice.htm
	@RequestMapping(value = "noticeReg.htm", method=RequestMethod.GET)
	public String noticeReg() {
		
		return "noticeReg";
	}
	
	//5.x.x 버전에서
	//@GetMapping
	//@PostMapping
	
	
	//글쓰기 처리(POST)
	@RequestMapping(value = "noticeReg.htm", method=RequestMethod.POST)
	public String noticeReg(Notice n, HttpServletRequest request) {
		System.out.println(n.toString());
		
		CommonsMultipartFile imagefile = n.getFile();
		System.out.println("imagefile.name: " + imagefile.getName());
		System.out.println("imagefile.getContentType: " + imagefile.getContentType());
		System.out.println("imagefile.getOriginalFilename: " + imagefile.getOriginalFilename());
		System.out.println("imagefile.getBytes: " + imagefile.getBytes().length);
		
		//cos.jar 자동 파일 업로드
		//실제 파일업로드는 구현(upload 업로드)
		String filename = imagefile.getOriginalFilename();
		String path = request.getServletContext().getRealPath("/customer/upload");//배포된 서버 경로
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
				e.getMessage();
			}
		}
		
		n.setFileSrc(filename);
		
		try {
			noticedao.insert(n); //실 DB insert
		} catch (Exception e) {
			e.getMessage();
		}
		
		//insert 나 update 하고 나면 (F5 누르면 계속 글이 Write)
		//리스트(locateion.href or redirect)
		//서버에게 새로운 요청 목록보기
		//String: redirect:notice.htm
		//Servlet, jsp : location.href or response.sendRedirect
		return "redirect:notice.htm";
	}
	
	
	
	//글 수정하기(화면) GET
	@RequestMapping(value = "noticeEdit.htm", method=RequestMethod.GET)
	public String noticeEdit(String seq, Model model) {
		
		//noticedao.getNotice(seq)
		Notice notice = null;
		try {
			notice = noticedao.getNotice(seq);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("notice", notice);
		
		return "noticeEdit";
	}
	
	//글 수정하기(처리) POST
	@RequestMapping(value = "noticeEdit.htm", method=RequestMethod.POST)
	public String noticeEdit(Notice n, HttpServletRequest request) {
		
		//파일 업로드 가능
		
		
		CommonsMultipartFile imagefile = n.getFile();
		
		//cos.jar 자동 파일 업로드
		//실제 파일업로드는 구현(upload 업로드)
		String filename = imagefile.getOriginalFilename();
		String path = request.getServletContext().getRealPath("/customer/upload");//배포된 서버 경로
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
				e.getMessage();
			}
		}
		
		n.setFileSrc(filename);
		
		try {
			noticedao.update(n); //실 DB insert
		} catch (Exception e) {
			e.getMessage();
		}
		
		
		return "redirect:noticeDetail.htm?seq=" + n.getSeq();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
