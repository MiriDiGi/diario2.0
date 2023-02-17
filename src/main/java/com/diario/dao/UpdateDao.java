package com.diario.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import com.diario.model.FormBean;

public class UpdateDao {
	public boolean updateFile(FormBean formBean) throws ClassNotFoundException {
		
		boolean status = false;
		String insert = "INSERT INTO log_form (attività, nome, cognome, presenti, mansione, fase_azione, fase_elaborazione) VALUES (?, ?, ?, ?, ?, ?, ?);";
		
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diario?log_form=root&password=YES");
			System.out.println("connessione stabilita con successo");
			
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			preparedStatement.setString(1, formBean.getAttività());
			preparedStatement.setString(2, formBean.getNome());
			preparedStatement.setString(3, formBean.getCognome());
			preparedStatement.setString(4, formBean.getPresenti());
			preparedStatement.setString(5, formBean.getMansione());
			preparedStatement.setString(6, formBean.getFase_azione());
			preparedStatement.setString(7, formBean.getFase_elaborazione());
			preparedStatement.executeUpdate();
			
			status=true;
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
		return status;
	}


}

