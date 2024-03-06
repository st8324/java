package kr.kh.app.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.Part;

public class FileUploadUtils {

	public static String getFileName(Part part) {
		String contentDisposition = part.getHeader("content-disposition");
		String [] items = contentDisposition.split(";");
		for(String item : items) {
			//item은 다음과 같은 형태로 구성
			//속성명 = 값
			if(item.trim().startsWith("filename")) {
				return item.substring(item.indexOf("=") + 2,item.length() - 1);
			}
		}
		return null;
	}
	
	public static String upload(String uploadPath, Part part) {
		String fileName = getFileName(part);
		//네트워크 상에서 서로 모르는 객체를 식별하고 구별하기 위한 문자열: 36개문자
		//8-4-4-4-12
		UUID uid = UUID.randomUUID();
		String filePath = calculatePath(uploadPath) +	File.separator + 
			uid + "_" +fileName; 
		try(InputStream is = part.getInputStream();
			OutputStream os = new FileOutputStream(uploadPath + filePath)){
			byte [] buffer = new byte[1024*4];//4kb씩 읽어와서 덮어쓰기
			int readCount;//읽어온 개수
			//InputStream.read(byte[])은 읽어와서 배열에 저장 후 읽어온 개수를 반환
			//읽어온 개수가 없으면 -1을 리턴
			while((readCount = is.read(buffer)) != -1) {
				os.write(buffer, 0, readCount);
			}
			return filePath.replace(File.separatorChar, '/');
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//년/월/일 폴더를 만들어서 해당 경로를 반환
	private static String calculatePath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		//\\2024
		String yearPath = File.separator + cal.get(Calendar.YEAR);
		//\\2024\\03
		String monthPath = yearPath + File.separator 
			+ new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		//\\2024\\03\\04
		String datePath = monthPath + File.separator 
			+ new DecimalFormat("00").format(cal.get(Calendar.DATE));
		makeDir(uploadPath, yearPath, monthPath, datePath);
		return datePath;
	}
	//uploadPath를 기준으로 paths들 폴더가 없으면 폴더를 생성해주는 메서드
	private static void makeDir(String uploadPath, String ... paths) {
		int lastIndex = paths.length - 1;
		//마지막 경로에 해당하는 폴더가 있으면 종료
		if(new File(uploadPath + paths[lastIndex]).exists()) {
			return;
		}
		for(String path : paths) {
			File dir = new File(uploadPath + path);
			if(!dir.exists()) {
				dir.mkdir();
			}
		}
	}

	public static void deleteFile(String fileName) {
		File file = new File(fileName);
		if(file.exists()) {
			file.delete();
		}
		
	}
}
