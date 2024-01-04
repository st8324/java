package day18.student2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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

	private static StudentManager sm = new StudentManager();
	private static String fileName = "src/day18/student/list2.txt";
	
	public static void main(String[] args) {
		int port = 5001;
		load();
		
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			while(true) {
				Thread t = new ServerThread(serverSocket.accept(), sm);
				t.start();
				//save();
			}
		} catch (IOException e) {
			System.out.println("[예외가 발생하여 서버를 종료합니다.]");
		}
		
	}
	
	private static void save() {
		try {
			ObjectOutputStream foos = 
				new ObjectOutputStream(new FileOutputStream(fileName));
			foos.writeObject(sm.getList());
			foos.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void load() {
		try {
			ObjectInputStream fois = 
				new ObjectInputStream(new FileInputStream(fileName));
			List<Student2>list = (List<Student2>)fois.readObject();
			sm = new StudentManager(list);
		} catch (IOException | ClassNotFoundException e) {
			sm = new StudentManager();
			e.printStackTrace();
		}
	}
}

@RequiredArgsConstructor
class ServerThread extends Thread{
	@NonNull
	private Socket socket;
	@NonNull
	private StudentManager sm;//서버에서 공유하는 학생 리스트
	
	private ObjectInputStream ois;//클라이언트에서 읽어오때 사용
	private ObjectOutputStream oos;//클라이언트에 보낼 때 사용

	public void run() {
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			while(true) {
				//클라이언트가 요청한 기능을 실행
				//클라이언트가 요청한 기능을 입력
				String menu = ois.readUTF();
				//요청한 기능을 실행 
				switch(menu) {
				case "LOAD":
					load();
					break;
				case "INSERT":
					insert();
					break;
				case "SAVE":
					//저장기능 실행
					save();
					return;
				case "UPDATE":
					update();
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void update() {
		try {
			Student2 std = (Student2) ois.readObject();
			sm.updateStudent(std);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void insert() {
		try {
			Student2 std = (Student2)ois.readObject();
			sm.insertStudent(std);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	private void load() {
		try {
			oos.writeObject(sm.getList());
			oos.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void save() {
		String fileName = "src/day18/student/list2.txt";
		try {
			ObjectOutputStream foos = 
				new ObjectOutputStream(new FileOutputStream(fileName));
			foos.writeObject(sm.getList());
			foos.flush();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

