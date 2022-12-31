package com.four.bookstore.web.servlet.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.four.bookstore.service.OrderService;

public class DelOrderByIdServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 订单id
		String id = request.getParameter("id");
		// 已支付的订单带有type值为client的参数
		String type = request.getParameter("type");

		OrderService service = new OrderService();

		if (type != null && type.trim().length() > 0) {

			service.delOrderById(id);

			if ("admin".equals(type)) {
				request.getRequestDispatcher("/findOrders").forward(request, response);
				return;
			}

		} else {
			// 调用service层方法删除相应订单
			service.delOrderByIdWithClient(id);
		}
		response.sendRedirect(request.getContextPath() + "/client/delOrderSuccess.jsp");
		return;
	}

}
