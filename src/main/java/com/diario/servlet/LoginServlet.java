package com.diario.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.diario.dao.LogInDao;
import com.diario.model.LoginBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LogInDao loginDao = new LogInDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher ("/view/filejsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginBean loginbean = new LoginBean();
        loginbean.setUsername(username);
        loginbean.setPassword(password);

        try {
        	
        	if (loginDao.loginUsers(loginbean)== true) {
        		 HttpSession session = request.getSession();
                session.setAttribute("username",username);
                RequestDispatcher dispatcher = request.getRequestDispatcher ("/view/filejsp/formvariation.jsp");
        		dispatcher.forward(request, response);
        	} else {
        		 HttpSession session = request.getSession();
                session.setAttribute("user", username);
                 response.sendRedirect("view/filejsp/loginfail.jsp");
        	}
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
	}

}
