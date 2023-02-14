package com.diario.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import com.diario.dao.FormDao;
import com.diario.model.FormBean;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    private FormDao formdao = new FormDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
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
		
		String data = request.getParameter("data");
		String attività = request.getParameter("attività");
		String compilatore = request.getParameter("compilatore");
		String mansione = request.getParameter("mansione");
		String azione = request.getParameter("azione");
		String elaborazione = request.getParameter("elaborazione");
		
		PDDocument document = new PDDocument();
		PDPage page = new PDPage();
		document.addPage(page);
		PDPageContentStream contentStream = new PDPageContentStream(document, page);
		
	    // scrivi i dati del form nel documento PDF
	    contentStream.beginText();
	    contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
	    contentStream.newLineAtOffset(100, 700);
	    contentStream.showText("Data di Creazione: " + data);
	    contentStream.newLineAtOffset(0, -20);
	    contentStream.showText("Attività: " + attività);
	    contentStream.newLineAtOffset(0, -20);
	    contentStream.showText("Compilatore: " + compilatore);
	    contentStream.newLineAtOffset(0, -20);
	    contentStream.showText("Mansione: " + mansione);
	    contentStream.newLineAtOffset(0, -20);
	    contentStream.showText("Fase dell'azione: " + azione);
	    contentStream.newLineAtOffset(0, -20);
	    contentStream.showText("Fasse dell'elaborazione: " + elaborazione);
	    contentStream.endText();
	    
	    contentStream.close();
	 // crea un ByteArrayOutputStream per salvare il PDF in memoria
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();

	    // invia il file PDF al client come risposta HTTP
	    response.setContentType("application/pdf");
	    response.setHeader("Content-Disposition", "attachment; filename=dati_form.pdf");
	    document.save(baos);
	    document.close();
	    
	    
	    //aggiungere ad array di byte
	    byte[] pdfByteArray = baos.toByteArray();
	}

}
