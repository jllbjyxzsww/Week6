package com.itheima.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.itheima.po.Customer;
import com.itheima.service.CustomerService;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/Customer")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Customer> customerList=CustomerService.findCustomer();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		Gson gson = new Gson();
	    String jsonStr = gson.toJson(customerList);
	    response.getWriter().println(jsonStr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String userName=request.getParameter("username");
		System.out.println(userName);
		String job=request.getParameter("job");
		String phone=request.getParameter("phone");
		Customer customer=new Customer();
		customer.setUserName(userName);
		customer.setJobs(job);
		customer.setPhone(phone);
		CustomerService.insertcustomer(customer);
		response.getWriter().print("插入成功");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}
	

}
