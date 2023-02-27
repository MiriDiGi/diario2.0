<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <link rel="preconnect" href="https://fonts.googleapis.com"> 
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
        <style> @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap'); </style>
        <link rel ="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/cronologia.css">
    <title>Diario di bordo</title>
</head>
<body>
<div class="bg">
    <h1>Cronologia</h1>
    <%
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diario?user=root&password=YioW1785");
        String query = "SELECT * FROM log_form";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
    %>
    <div class="table-wrapper">
    <table class="fl-table">
        <thead>
            <tr>
                <th id="border-top-left">Id</th>
                <th>Attività</th>
                <th>Compilatore</th>
                <th>Presenti</th>
                <th>Mansione</th>
                <th>Fase dell'azione</th>
                <th>Fase dell'elaborazione</th>
                <th id="border-top-right">Data</th>
            </tr>
        </thead>
        <tbody>
            <% while (resultSet.next()) { %>
            <tr>
                <td><%= resultSet.getString("id") %></td>
                <td><%= resultSet.getString("attività") %></td>
                <td><%= resultSet.getString("compilatore") %></td>
                <td class="text-left"><%= resultSet.getString("presenti") %></td>
                <td class="text-left"><%= resultSet.getString("mansione") %></td>
                <td><a href="DownloadServlet?fileName=<%=resultSet.getString("fase_azione")%>"><%=resultSet.getString("fase_azione")%></a></td>
                <td><a href="DownloadServlet?fileName=<%=resultSet.getString("fase_elaborazione")%>"><%=resultSet.getString("fase_elaborazione")%></a></td>
                 <td><%= resultSet.getString("added_date") %></td>
            </tr>
            <% } %>
        </tbody>
    </table>
    </div>
    </div>
</body>
</html>
