package day18.student;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import program.Program;

public class StudentProgram implements Program {

	private final int EXIT = 3;
	private Scanner scan = new Scanner(System.in);
	private StudentManager sm = new StudentManager();
	private Socket socket;
	
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
		}
		try {
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeUTF("LOAD");;
			oos.flush();
			//읽어옴
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			List<Student> list = (List<Student>)ois.readObject();
			sm = new StudentManager(list);
			System.out.println("[불러오기 성공]");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("[불러오기 중 예외가 발생했습니다.]");
		}
		
		
	}

	private void connectServer(String ip, int port) {
		try {
			socket = new Socket(ip, port);
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
		System.out.println("3. 종료");
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
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			throw new InputMismatchException();
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
		Student std = new Student(grade, classNum, num, name);
		if(sm.insertStudent(std)) {
			System.out.println("학생을 추가했습니다.");
		}else {
			System.out.println("이미 등록된 학생입니다.");
		}
	}

	private void printStudent() {
		//매니저에게 전체 학생 정보를 출력
		sm.printStudent();
	}
}
