package com.four.bookstore.web.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.four.bookstore.domain.Product;
import com.four.bookstore.exception.ListProductException;
import com.four.bookstore.service.ProductService;

/**
 * 后台系统
 * 查询所有商品信息的servlet
 */
public class ListProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 创建service层的对象
		ProductService service = new ProductService();
		try {
			// 调用service层用于查询所有商品的方法
			List<Product> ps = service.listAll();
			// 将查询出的所有商品放进request域中
			request.setAttribute("ps", ps);
			// 重定向到list.jsp页面
			request.getRequestDispatcher("/admin/products/list.jsp").forward(
					request, response);
			return;
		} catch (ListProductException e) {
			e.printStackTrace();
			response.getWriter().write(e.getMessage());
			return;
		}
	}
}
