package com.four.bookstore.web.servlet.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.four.bookstore.domain.Order;
import com.four.bookstore.service.OrderService;

public class FindOrderByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String type=request.getParameter("type");
		
		// 1.得到要查询的订单的id
		String id = request.getParameter("id");

		// 2.根据id查找订单
		OrderService service = new OrderService();
		Order order = service.findOrderById(id);

		request.setAttribute("order", order);
		
		if(type!=null){
			request.getRequestDispatcher("/admin/orders/view.jsp").forward(request, response);
			return;
		}
		request.getRequestDispatcher("/client/orderInfo.jsp").forward(request, response);
	}

}
