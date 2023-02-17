package com.diario.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UpdateNewServlet
 */
@WebServlet("/update")
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 2,  // 2MB
		  maxFileSize = 1024 * 1024 * 10,       // 10MB
		  maxRequestSize = 1024 * 1024 * 50     // 50MB
		)
public class UpdateNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	PrintWriter out = null;
	Connection connection = null;
	PreparedStatement ps = null;
	HttpSession session = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain;charset=UTF-8");
		
		try {
			out = response.getWriter();
			session = request.getSession(false);
			String folderName = "textfile";
			String uploadPath = "C:/Users/hp/Desktop/Code for Future/dev/diario2.0/src/main/webapp/textfile/";
			File dir = new File (uploadPath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			Part filePart =  request.getPart ("fase_azione");
			System.out.println(filePart);
			String attività = request.getParameter("attivita");
			System.out.println(attività);
	        String nome = request.getParameter("nome");
	        System.out.println(nome);
	        String cognome = request.getParameter("cognome");
	        System.out.println(cognome);
	        String presenti = request.getParameter("presenti");
	        System.out.println(presenti);
	        String mansione = request.getParameter("mansione");
	        String fileName = filePart.getSubmittedFileName();
	        String path = folderName + File.separator + fileName;
	        java.sql.Timestamp added_date = new java.sql.Timestamp(serialVersionUID);
	        System.out.println("path" + uploadPath);
	        InputStream is = filePart.getInputStream();
	        Files.copy(is, Paths.get(uploadPath + fileName), StandardCopyOption.REPLACE_EXISTING);
	        
	        try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diario?log_form=root&password=YioW1785");
				String insert = "INSERT INTO log_form (attività, nome, cognome, presenti, mansione, fase_azione, fase_elaborazione) VALUES (?, ?, ?, ?, ?, ?, ?);";
				PreparedStatement preparedStatement = connection.prepareStatement(insert);
				preparedStatement.setString(1, attività);
				preparedStatement.setString(2, nome);
				preparedStatement.setString(3, cognome);
				preparedStatement.setString(4, presenti);
				preparedStatement.setString(5, mansione);
				preparedStatement.setString(6, fileName);
				preparedStatement.setString(7, fileName);
				int status = preparedStatement.executeUpdate();
				if (status > 0) {
					session.setAttribute("fileName", fileName);
					String msg = "" + fileName + "file Uploaddato";
					request.setAttribute("msg", msg);
					RequestDispatcher rd = request.getRequestDispatcher("/view/filejsp/cronologia.jsp");
					rd.forward(request, response);
					System.out.println("file uploaddato");
					System.out.println("uploaddato path" + uploadPath);
				}
	        } catch (SQLException e) {
				System.out.println("Errore di connessione al database: " + e.getMessage());
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			
			
				}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("Errore durante la chiusura della connessione: " + e.getMessage());
			}
		}
		}
	}


