package com.diario.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.diario.model.FormBean;
import com.diario.model.Users;


public class FormDao {	
	 
//	public int registerUsers(Users users) throws ClassNotFoundException {
//	        String INSERT_PDF_SQL = "INSERT INTO file_pdf" + " (file_pdf, data_creazione, username) VALUES" + " (?, ?, ?);";
//
//	        int result = 0;
//
//	        // Carico il driver JDBC
//	        Class.forName("com.mysql.cj.jdbc.Driver");
//
//
//	        Connection connection = null;
//	        try {
//	            // Crea la connessione con il database
//	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diario?user=root&password=YioW1785");
//	            System.out.println("Connessione al database stabilita con successo");
//
//	            // Crea la query SQL per inserire i dati nella tabella user
//	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PDF_SQL);
//	            preparedStatement.setBlob(1, baos);
//	            preparedStatement.setString(2, users.getCognome());
//	            preparedStatement.setString(3, users.getUsername());
//	            preparedStatement.setString(4, users.getEmail());
//	            preparedStatement.setString(5, users.getPassword());
//
//	            System.out.println(preparedStatement);
//
//	            // Esegui la query o aggiorna la query
//	            result = preparedStatement.executeUpdate();
//	        } catch (SQLException e) {
//	            System.out.println("Errore di connessione al database: " + e.getMessage());
//	        } finally {
//	            try {
//	                if (connection != null) {
//	                    connection.close();
//	                }
//	            } catch (SQLException e) {
//	                System.out.println("Errore durante la chiusura della connessione: " + e.getMessage());
//	            }
//	        }
//
//	        return result;
//	    }
	}

