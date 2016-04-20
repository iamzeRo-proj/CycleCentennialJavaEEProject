package com.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BikeInfoDAO;

/**
 * Servlet implementation class GetBikeInfoServlet
 */
@WebServlet("/ReserveBikeServlet")
public class ReserveBikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReserveBikeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String location = request.getParameter("location");
		BikeInfoDAO bikeInfoDao = new BikeInfoDAO();

		if (bikeInfoDao.getBikeInfo("available",location).size() > 0) {
			response.sendRedirect("/Cycle.Centennial/faces/payment.xhtml");
			
		}else{
			response.getWriter().append("the location you choose:" + location+" there is no more available bikes");
		}
	}

}
