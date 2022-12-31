package com.four.bookstore.web.servlet.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.four.bookstore.domain.Product;
import com.four.bookstore.exception.FindProductByIdException;
import com.four.bookstore.service.ProductService;

public class AddCartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.得到商品id
		String id = request.getParameter("id");
		// 2.调用service层方法，根据id查找商品
		ProductService service = new ProductService();
		try {
			Product p = service.findProductById(id);
			// 将商品添加到购物车
			HttpSession session = request.getSession();
			//从session中获取购物车对象
			Map<Product, Integer> cart = (Map<Product, Integer>)session.getAttribute("cart");
			//如果购物车为null,说明没有商品存储在购物车中，创建出购物车
			if (cart == null) {
				cart = new HashMap<Product, Integer>();
			}
			//如果count返回不为null,说明商品在购物车中存在。
			Integer count = cart.put(p, 1);
			if (count != null) {
				cart.put(p, count + 1);
			}

			session.setAttribute("cart", cart);

			response.sendRedirect(request.getContextPath() + "/client/cart.jsp");
			return;
		} catch (FindProductByIdException e) {
			e.printStackTrace();
		}

	}

}
