package com.diario.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public static int BUFFER_SIZE = 1024 * 100;
	public static final String UPLOAD_DIR = "textfile/";
	public static String fileName = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	fileName = request.getParameter("fileName");
	if (fileName == null || fileName.equals("")) {
		// response content type
		
		response.setContentType("text/html");
		
		// print response
		
		response.getWriter().println("<h3> File" + fileName + "Is not present! </h3>"); }
		
		else {
			String applicationPath = "C:/Users/hp/Desktop/Code for Future/dev/diario2.0/src/main/webapp/";
			String downloadPath = applicationPath + UPLOAD_DIR;
			String filePath = downloadPath  + fileName;
			System.out.println(fileName);
			System.out.println(filePath);
			System.out.println("fileName: " + fileName);
			System.out.println("filePath: " + filePath);
			File file = new File(filePath);
			OutputStream outStream = null;
			FileInputStream inputStream = null;
			
			if (file.exists()) {
				// setting the content attribute for the response object
//				String mimeType = "application/octet-strem";
//				response.setCharacterEncoding(mimeType);
				
				//setting headers for the response object
				
				String headerKey = "Content-Disposition";
				String headerValue = String.format("attachment; filename=\"%s\"", file.getName());
				response.setHeader(headerKey, headerValue);
				
				try {
					//get the output stream of the response
					
					outStream = response.getOutputStream();
					inputStream = new FileInputStream(file);
					byte[] buffer = new byte[BUFFER_SIZE];
					int bytesRead = -1;
					
					
					//write each byte of data from the input stram  into output
					
					while ((bytesRead = inputStream.read(buffer)) != -1) {
						outStream.write(buffer, 0, bytesRead);
					}
				} catch (IOException ioExObj) {
					System.out.println("eccezione mentre si performa l'operazione I/O?= " + ioExObj.getMessage());
					
				} finally {
					if (inputStream != null) {
						inputStream.close();
					}
					
					
					if (outStream != null) {
						outStream.flush();
						outStream.close();
					}
				}
			} else {
				//set response content type
				response.setContentType("text/html");
				
				//printa la risposta
				
				response.getWriter().println("<h3> File\" + fileName + \"Is not present! </h3>");
				System.out.println("il file non esiste");
			}
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
