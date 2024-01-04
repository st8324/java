package day18.student;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class ServerMain {

	public static void main(String[] args) {
		int port = 5001;
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			while(true) {
				Thread t = new ServerThread(serverSocket.accept());
				t.start();
			}
		} catch (IOException e) {
			System.out.println("[예외가 발생하여 서버를 종료합니다.]");
		}
	}
}

@RequiredArgsConstructor
class ServerThread extends Thread{
	@NonNull
	private Socket socket;
	
	private ObjectInputStream ois;//클라이언트에서 읽어오때 사용
	private ObjectOutputStream oos;//클라이언트에 보낼 때 사용
	
	public void run() {
		try {
			//클라이언트가 요청한 기능을 실행
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			//클라이언트가 요청한 기능을 입력
			String menu = ois.readUTF();
			//요청한 기능을 실행 
			switch(menu) {
			case "LOAD":
				load();
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void load() {
		String fileName = "src/day18/student/list.txt";
		//나중에 파일에서 읽어올 학생 정보로 바뀔 예정
		List<Student> list = new ArrayList<Student>();
		list.add(new Student(1,1,1,"홍길동"));
		list.add(new Student(1,1,2,"임꺽정"));
		
		try {
			oos.writeObject(list);
			oos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

