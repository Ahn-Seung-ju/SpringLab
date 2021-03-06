package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.OrderCommand;

/*
하나의 요청 주소로 2개 업무 처리
/ordre/order.do

화면:GET
처리:POST
 */
@Controller
@RequestMapping("/order/order.do")
public class OrderController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String form() {
		return "order/OrderForm";//view 주소를 리턴
		// 	/WEB-INF/views/order/OrderForm.jsp
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(OrderCommand ordercommand) {
		/*
			주문 발생
			OrderCommand command = new OrderCommand();

			List<OrderItem> itemlist = new ArrayList<>();
			list.add(new OrderItem(1,10,"파손주의");
			list.add(new OrderItem(10,1,"리모컨 별도 구매");

			command.setOrderItem(itemlist);
			
			forward 객체 key >> orderCommand
		 */
		return "order/OrderCommited";
	}
}
