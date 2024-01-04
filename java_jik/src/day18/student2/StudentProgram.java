package day18.student2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import program.Program;

public class StudentProgram implements Program {

	private final int EXIT = 4;
	private Scanner scan = new Scanner(System.in);
	private StudentManager sm = new StudentManager();
	private Socket socket;
	
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	@Override
	public void run() {
		String ip = "192.168.30.199";
		int port = 5001;
		//서버와 연결
		connectServer(ip, port);
		//서버에서 학생 정보를 불러옴
		load();
		int menu = 0;
		do {
			try {
				//메뉴 출력
				printMenu();
				//메뉴 선택
				menu = scan.nextInt();
				//메뉴 실행
				runMenu(menu);
			}catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴를 선택했습니다.");
				scan.nextLine();//입력 버퍼에 잘못 입력된 값을 제거 또는 공백을 제거
			}
		}while(menu != EXIT);
	}

	private void load() {
		if(socket == null) {
			System.out.println("[서버에 연결되지 않아 불러올 수 없습니다.]");
			return;
		}
		try {
			oos.writeUTF("LOAD");;
			oos.flush();
			//읽어옴
			List<Student2> list = (List<Student2>)ois.readObject();
			sm = new StudentManager(list);
			System.out.println("[불러오기 성공]");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("[불러오기 중 예외가 발생했습니다.]");
		}
	}

	private void connectServer(String ip, int port) {
		try {
			socket = new Socket(ip, port);
			System.out.println(socket);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
			System.out.println("[서버 연결 성공]");
		} catch (IOException e) {
			System.out.println("[서버 연결 실패]");
		}
		
	}

	@Override
	public void printMenu() {
		System.out.println("------메뉴------");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 조회(전체)");
		System.out.println("3. 학생 수정(이름)");
		System.out.println("4. 종료");
		System.out.println("---------------");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertStudent();
			break;
		case 2:
			printStudent();
			break;
		case 3:
			updateStudent();
			break;
		case 4:
			exit();
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			throw new InputMismatchException();
		}
	}


	private void updateStudent() {
		//학생 정보 입력
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반  : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		System.out.print("이름 : ");
		scan.nextLine();
		String name = scan.nextLine();
		
		//학생정보 수정
		Student2 std = new Student2(grade, classNum, num, name);
		if(sm.updateStudent(std)) {
			System.out.println("이름을 수정했습니다.");
			sendUpdateStudent(std);
		}else {
			System.out.println("등록되지 않은 학생입니다.");
		}
	}

	private void sendUpdateStudent(Student2 std) {
		if(socket == null) {
			return;
		}
		try {
			oos.writeUTF("UPDATE");
			oos.flush();
			oos.writeObject(std);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void exit() {
		if(socket == null) {
			return;
		}
		try {
			oos.writeUTF("SAVE");
			oos.flush();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void insertStudent() {
		//추가할 학생 정보를 입력
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반  : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		System.out.print("이름 : ");
		scan.nextLine();
		String name = scan.nextLine();
		//매니저에게 입력받은 학생 정보를 추가
		Student2 std = new Student2(grade, classNum, num, name);
		if(sm.insertStudent(std)) {
			System.out.println("학생을 추가했습니다.");
			sendStudent(std);
		}else {
			System.out.println("이미 등록된 학생입니다.");
		}
	}

	private void sendStudent(Student2 std) {
		if(socket == null) {
			System.out.println("[서버에 연결되지 않아 서버에 학생 정보를 추가할 수 없습니다.]");
		}
		try {
			oos.writeUTF("INSERT");;
			oos.flush();
			oos.writeObject(std);
			oos.flush();
			System.out.println("[서버에 학생 추가 성공]");
		} catch (IOException  e) {
			System.out.println("[서버에 학생 추가 중 예외가 발생했습니다.]");
		}
		
	}

	private void printStudent() {
		//매니저에게 전체 학생 정보를 출력
		sm.printStudent();
	}
}
