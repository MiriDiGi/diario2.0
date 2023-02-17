package com.diario.servlet;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.diario.dao.FormDao;
import com.diario.model.FileModel;

/**
 * Servlet implementation class SavePdfServlet
 */
@WebServlet("/savepdf")
public class SavePdfServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final int BUFFER_SIZE = 4096;
    
    private FormDao formDao = new FormDao();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SavePdfServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // leggi il contenuto del file PDF
        InputStream inputStream = request.getInputStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        byte[] pdfData = outputStream.toByteArray();
        outputStream.close();
        inputStream.close();
        
        // crea un file temporaneo e scrivi i dati del PDF
        File tempFile = File.createTempFile("temp", ".pdf");
        FileOutputStream fileOutputStream = new FileOutputStream(tempFile);
        fileOutputStream.write(pdfData);
        fileOutputStream.close();
        
        // salva il contenuto del file PDF nel database tramite DAO
        FileModel fileModel = new FileModel();
        fileModel.setName("file.pdf"); // impostare il nome del file
        fileModel.setType("application/pdf"); // impostare il tipo MIME
        fileModel.setData(pdfData); // impostare i dati del file
        try {
			formDao.savePdf(fileModel);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // rimuovi il file temporaneo
        tempFile.delete();
        
        // invia una risposta vuota
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write("File salvato con successo.");
        
        // inoltra la richiesta
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/filejsp/cronologia.jsp");
		dispatcher.forward(request, response);
    }

}