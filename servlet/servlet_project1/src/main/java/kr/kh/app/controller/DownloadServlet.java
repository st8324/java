package kr.kh.app.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
	private String uploadPath = "D:\\uploads";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("filename");
		String filePath = uploadPath + fileName.replace('/', File.separatorChar);
		File file = new File(filePath);
		try(FileInputStream fis = new FileInputStream(file);
			OutputStream os = response.getOutputStream()){
			String mimeType = getServletContext().getMimeType(filePath);
			
			response.setContentType(mimeType != null ? mimeType : "application/octet-stream");
			response.setContentLength((int)(file.length()));
			response.setHeader("Content-Disposition", "attachment : filename=\"" + fileName + "\"");
			
			byte[] buffer = new byte[1024 * 4];
			int readCount;
			while((readCount = fis.read(buffer)) != -1) {
				os.write(buffer, 0, readCount);
			}
		}
	}
}
