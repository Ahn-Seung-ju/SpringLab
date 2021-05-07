package DI_08_Spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		
		//java코드
		/*
		JobExecute jobexecute = new JobExecute("hong", 100);
		
		//JobExecute jobeexcute2 = new JobExecute("hong", 100L);
		//JobExecute jobeexcute3 = new JobExecute("hong", "gildong");
		
		ArticleDao articledao = new ArticleDao();
		jobexecute.setArticledao(articledao);
		
		jobexecute.setData(500);
		*/
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_08_Spring/DI_082.xml");
		
	}
	

}


