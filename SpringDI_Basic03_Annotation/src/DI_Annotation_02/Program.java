package DI_Annotation_02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Program {

	public static void main(String[] args) {
		/*
		MonitorViewer viewer = new MonitorViewer();
		Recorder recorder  = new Recorder();
		
		viewer.setRecorder(recorder); //주입(injection)
		System.out.println(viewer.getRecorder());
		*/
		
		ApplicationContext context = 
				new GenericXmlApplicationContext("classpath:DI_Annotation_02/DI_Annotation_02.xml");
		 MonitorViewer  viewer = context.getBean("monitorViewer" , MonitorViewer.class);
		 
		 viewer.getRecorder();
	}

}