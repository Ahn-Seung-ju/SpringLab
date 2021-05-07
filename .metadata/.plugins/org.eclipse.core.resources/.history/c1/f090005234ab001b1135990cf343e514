package DI_Spring04;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp4 {

	public static void main(String[] args) {
		/*
		ProtocolHandler_P handler = new ProtocolHandler_P();
		
		List<MyFilter_P> list = new ArrayList<MyFilter_P>();
		
		list.add(new EncFIlter_P());
		list.add(new HeaderFilter_P());
		list.add(new ZipFilter_P());
		
		handler.setFilters(list);
		System.out.println(handler.filters_length());
		*/
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_Spring04/DI_04_Spring_P.xml");
		
		ProtocolHandler_P handler = context.getBean("protocolHandler_P",ProtocolHandler_P.class);
		
		System.out.println(handler.filters_length());
		
	}

	
	
}
