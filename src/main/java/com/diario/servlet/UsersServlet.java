package com.diario.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.diario.dao.UsersDao;
import com.diario.model.Users;

/**
 * Servlet implementation class UsersServlet
 */
@WebServlet("/register")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UsersDao usersDao = new UsersDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher ("/view/filejsp/usersregistration.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
	    String cognome = request.getParameter("cognome");
	    String username = request.getParameter("username");
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    
	    Users users = new Users();
	    users.setNome(nome);
	    users.setCognome(cognome);
	    users.setUsername(username);
	    users.setEmail(email);
	    users.setPassword(password);
	    
	    try {
	    		usersDao.registerUsers(users);
	    } catch (ClassNotFoundException e) {
	    	e.printStackTrace();
	    }
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher ("/view/filejsp/login.jsp");
		dispatcher.forward(request, response);
	}

}
