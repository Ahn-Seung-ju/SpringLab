package DI_Annotation_1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
		/*
		MoniterViewer viewer = new MoniterViewer();
		Recorder recorder = new Recorder();
		
		viewer.setRecorder(recorder);
		
		System.out.println(viewer.getRecorder());
		*/
		
		ApplicationContext context = 
				new GenericXmlApplicationContext("classpath:DI_Annotation_03/DI_Annotation_03.xml");
		
		MoniterViewer viewer = context.getBean("moniterViewer", MoniterViewer.class);
		System.out.println(viewer.getRecorder());
	}

}
