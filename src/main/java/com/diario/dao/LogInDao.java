package com.diario.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import com.diario.model.LoginBean;

public class LogInDao {
	
	public boolean loginUsers(LoginBean loginbean) throws ClassNotFoundException {
        
		boolean status = false;

        // Carico il driver JDBC
		Class.forName("com.mysql.cj.jdbc.Driver");


        Connection connection = null;
        try {
            // Crea la connessione con il database
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diario?user=root&password=YioW1785");
            System.out.println("Connessione al database stabilita con successo");

            // Controllare se l'imput è inserito nella tabella user
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE username = ? and password = ?;");
            preparedStatement.setString(1, loginbean.getUsername());
            preparedStatement.setString(2, loginbean.getPassword());

            System.out.println(preparedStatement);

            // Esegui la query o aggiorna la query
            ResultSet result = preparedStatement.executeQuery();
            status = result.next();
            
        } catch (SQLException e) {
            System.out.println("Errore di connessione al database: " + e.getMessage());
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


