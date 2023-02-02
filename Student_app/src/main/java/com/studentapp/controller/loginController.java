package com.studentapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studentapp.Model.DAOService;
import com.studentapp.Model.DAOServiceImpl;


@WebServlet("/login")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     public loginController() {
        super();

     }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			DAOService service = new DAOServiceImpl();
			service.connectionDB();
			
			boolean status = service.verifycredentials(email, password);
			
			if(status==true) {
				HttpSession session = request.getSession(true);
				session.setAttribute("email", email);
				session.setMaxInactiveInterval(10);
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/registration.jsp");
				rd.forward(request, response);
			}
			else {
				request.setAttribute("error", "invalid username/password");
				
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
				
			}
			
			
	}

}
