package com.diario.servlet;

import java.io.File;

import java.io.IOException;
import java.io.OutputStream;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import com.diario.model.FormBean;

//DA RIVEDERE/AGGIUNGERE I NOMI DEL FORM.JSP PER FARLI MATCHARE CON IL FORMBEAN ALTRIMENTI ESCONO UNA VAGONATA DI NULL!!!

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/save")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	FormBean formBean = new FormBean();
	
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
		
		RequestDispatcher dispatcher = request.getRequestDispatcher ("/view/filejsp/form.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		formBean.setData(request.getParameter("data"));
		formBean.setAttività(request.getParameter("attività"));
	//	formBean.setCompilatore(request.getParameter("compilatore"));
		formBean.setMansione(request.getParameter("mansione"));
		formBean.setAzione(request.getParameter("azione"));
		formBean.setElaborazione(request.getParameter("elaborazione"));
		
		// Creazione di un oggetto File per la cartella in cui salvare il PDF
		File directory = new File(getServletContext().getRealPath("/pdf"));

		// Se la cartella non esiste, la crea
		if (!directory.exists()) {
		    directory.mkdirs();
		}

		// Creazione del nome del file PDF
		String fileName = "form.pdf";
		File file = new File(directory, fileName);
		
		//creo documento usando libreria pdfbox
		PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        
        //inserire elementi nel pdf
        contentStream.beginText();
        contentStream.setFont(PDType1Font.TIMES_ROMAN, 14);
        contentStream.setLeading(16.0f);
        contentStream.newLineAtOffset( 70, page.getTrimBox().getHeight()-80);
        //titolo + logo non ancora implementato
        contentStream.showText("Data di compilazione: " + formBean.getData());
        contentStream.newLine();
        contentStream.showText("Attività: " + formBean.getAttività());
        contentStream.newLine();
 //       contentStream.showText("Compilatore: " + formBean.getCompilatore());
        contentStream.newLine();
        contentStream.showText("Mansione: " + formBean.getMansione());
        contentStream.newLine();
        contentStream.showText("Fase dell'azione: " + formBean.getAzione());
        contentStream.newLine();
        contentStream.showText("Fase dell'elaborazione: " + formBean.getElaborazione());
        contentStream.endText();
        contentStream.close();

     // Salvataggio del documento PDF nella cartella specificata
        document.save(file);
        
       //riga 108/109 aggiunta. quello sopra funziona
        String savePDFServletURL = request.getContextPath() + "/savepdf";
        response.sendRedirect(savePDFServletURL);

        // Invio il documento PDF come risposta alla richiesta HTTP
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
        OutputStream outputStream = response.getOutputStream();
        document.save(outputStream);
        outputStream.close(); 
        
        //chiudo documento
        document.close();
        System.out.println("pdf creato");
        
        
        
	}

}
