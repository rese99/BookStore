package com.four.bookstore.web.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.four.bookstore.domain.Product;
import com.four.bookstore.service.ProductService;

public class FindProductByManyConditionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id"); // 商品id
		String name = request.getParameter("name"); // 商品名称
		String category = request.getParameter("category"); // 商品类别
		String minprice = request.getParameter("minprice"); // 最小价格
		String maxprice = request.getParameter("maxprice"); // 最大价格

		ProductService service = new ProductService();
		List<Product> ps = service.findProductByManyCondition(id, name,
				category, minprice, maxprice);

		request.setAttribute("ps", ps);

		request.getRequestDispatcher("/admin/products/list.jsp").forward(
				request, response);

	}

}
