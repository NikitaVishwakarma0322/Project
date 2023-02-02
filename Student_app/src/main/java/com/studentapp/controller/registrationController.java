package com.studentapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studentapp.Model.DAOService;
import com.studentapp.Model.DAOServiceImpl;

@WebServlet("/registration")
public class registrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public registrationController() {
        super();

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/registration.jsp");
    	rd.forward(request, response);
	}


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		try {
    		HttpSession session = request.getSession();
    		if(session.getAttribute("email")!=null) {
    	
    		String name = request.getParameter("name");
    		String city = request.getParameter("city");
    		String email = request.getParameter("email");
    		String mobile = request.getParameter("mobile");
    		
    		DAOService service = new DAOServiceImpl();
    		service.connectionDB();
    		
    		service.SaveReg(name,city,email,mobile);
    		
    		request.setAttribute("msg","Record is save" );
    		
    		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/registration.jsp");
    		rd.forward(request, response);
    		}
    		else {
    			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        		rd.forward(request, response);
        		
    		}
    		}
    		catch(Exception e) {

        		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/registration.jsp");
        		rd.forward(request, response);
        		
    		}
    		
    		
    }

}
