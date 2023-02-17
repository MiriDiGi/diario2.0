package com.diario.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.diario.model.FileModel;


public class FormDao {
	
	public int savePdf(FileModel fileModel) throws ClassNotFoundException {
		String insert = "INSERT INTO log_pdf (username, path_pdf, added_date) VALUES (?, ?, ?);";
		
		int result = 0;
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diario?user=root&password=YioW1785");
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			preparedStatement.setString(1, fileModel.getName());
			preparedStatement.setString(2, fileModel.getType());
			preparedStatement.setString(3, new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()));
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Errore di connessione al database: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println("Errore durante la chiusura della connessione: " + e.getMessage());
			}
		}
		return result;
	}


}

