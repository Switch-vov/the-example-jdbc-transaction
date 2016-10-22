package com.pc.project.jdbc.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pc.project.jdbc.service.AccountServiceInter;
import com.pc.project.jdbc.service.impl.AccountServiceImpl;

/**
 * 账号Servlet
 * 
 * @author Switch
 * @data 2016年10月17日
 * @version V1.0
 */
public class AccountServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		AccountServiceInter accountService = new AccountServiceImpl();
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		Double money = null;
		try {
			money = Double.parseDouble(request.getParameter("money"));
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().write("数字错误");
		}
		if (accountService.transferMoney(from, to, money)) {
			response.getWriter().write("转账成功");
		} else {
			response.getWriter().write("转账失败");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}