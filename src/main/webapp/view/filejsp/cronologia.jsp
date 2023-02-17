<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Diario di bordo</title>
</head>
<body>
    <h1>Elenco dei log</h1>
    <%
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diario?user=root&password=YioW1785");
        String query = "SELECT * FROM log_form";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
    %>
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Attività</th>
                <th>Nome</th>
                <th>Cognome</th>
                <th>Presenti</th>
                <th>Mansione</th>
                <th>Fase dell'azione</th>
                <th>Data</th>
            </tr>
        </thead>
        <tbody>
            <% while (resultSet.next()) { %>
            <tr>
                <td><%= resultSet.getString("id") %></td>
                <td><%= resultSet.getString("attività") %></td>
                <td><%= resultSet.getString("nome") %></td>
                <td><%= resultSet.getString("cognome") %></td>
                <td><%= resultSet.getString("presenti") %></td>
                <td><%= resultSet.getString("mansione") %></td>
                <td><a href="DownloadServlet?fileName=<%=resultSet.getString("fase_azione")%>"><%=resultSet.getString("fase_azione")%></a></td>
                <td><%= resultSet.getString("added_time") %></td>
            </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
