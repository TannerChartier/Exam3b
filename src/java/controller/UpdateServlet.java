/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dbhelpers.UpdateQuery;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customers;

/**
 *
 * @author Tanner
 */
@WebServlet(name = "UpdateServlet", urlPatterns =
{
	"/updateCustomer"
})
public class UpdateServlet extends HttpServlet
{

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter())
		{
			/* TODO output your page here. You may use following sample code. */
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet UpdateServlet</title>");			
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet UpdateServlet at " + request.getContextPath() + "</h1>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		doPost(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		//linked to update.jsp
		String custID = request.getParameter("custID");
		String custFName = request.getParameter("fName");
		String custLName = request.getParameter("lName");
		String custAddr1 = request.getParameter("addr1");
		String custAddr2 = request.getParameter("addr2");
		String custCity = request.getParameter("city");
		String custState = request.getParameter("state");
		String custZip = request.getParameter("zip");
		String custEmailAddr = request.getParameter("emailAddr");
		int custAge = Integer.parseInt(request.getParameter("age"));

		//set up a customer object
		Customers customer = new Customers();
		
		customer.setCustomerID(Integer.parseInt(custID));
		customer.setCustFName(custFName);
		customer.setCustLName(custLName);
		customer.setCustAddr1(custAddr1);
		customer.setCustAddr2(custAddr2);
		customer.setCustCity(custCity);
		customer.setCustState(custState);
		customer.setCustZip(custZip);
		customer.setCustEmailAddr(custEmailAddr);
		customer.setCustAge(custAge);
		
		//create an UpdateQuery object and use it to update the customer
		UpdateQuery uq = new UpdateQuery();
		uq.doUpdate(customer);
		
		//pass control on to read servlet
		String url = "/read";

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo()
	{
		return "Short description";
	}// </editor-fold>

}
