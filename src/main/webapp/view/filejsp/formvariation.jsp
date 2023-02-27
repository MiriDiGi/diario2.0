<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.diario.dao.LogInDao"%>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html lang="it">
    <head>
        <title>Diario Di Bordo</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <link rel="preconnect" href="https://fonts.googleapis.com"> 
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
        <style> @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap'); </style>
        <link rel ="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/form.css">
        <meta charset="UTF-8">
    </head>
    <body>
        <div class="container-bg">
            <div class="container"> 
                <div class="item">
                    <h1>Diario di bordo</h1>
                </div>
                <div class="item">
                    <img src="${pageContext.request.contextPath}/css/img/book.png" alt="immagine diario">
                </div>
                <div class="item">
                    <form action="<%= request.getContextPath()%>/update" method="post" enctype="multipart/form-data">
                        <div class="form_group field">
                            <div class="date">
                                <label for="data">Data di compilazione:</label>
                                <%= new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()) %>
                            </div>
                            <div class="item1"> 
                                <label for="attivita">Attività:</label><br>
                                <input type="text" name="attivita" class="form_field" required>
                                <span class="focus-border"></span>
                            </div>               
                            <div class="item2">
                                <label for="compilatore">Compilatore:</label><br>
                                <input type="text" name="compilatore" class="form_field" placeholder="Inserire nome e cognome" id="name_label" required>
                               
                            </div>
                            <div class="item3">
                                <label for="presenti">Presenti:</label><br>                     
                      
                            		<textarea name="presenti" style="width: 340px; height: 150px;"></textarea>
                            		<textarea name="mansione" style="width: 340px; height: 150px;"></textarea>
                            		
                            </div>
                            <div>
                                <label  for="azione">Fase dell'azione:</label><br>
                                <input type="file" name="fase_azione" class="label_file">
                            </div>
                            <div>
                                <label for="elaborazione">Fase dell'elaborazione:</label><br>
								<input type="file" class="label_file" name="fase_elaborazione">
                            </div>
                            <div  class="item4"> 
                                <button type="reset" class="reset_btn">Reset</button>
                                <button type="submit" value="Submit" class="item3" id="send_btn">Conferma</button>
                               
                            </div>  
                        </div>
                    </form>
                </div>
            </div>   
        </div>
    </body>
</html>