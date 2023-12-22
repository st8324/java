package day11.product;

import java.util.Scanner;

import day10.word.Word;

public class ProductMain {

	private static Scanner scan = new Scanner(System.in);
	private static Product[] list = new Product[10];
	private static Product[] saleList = new Product[10];
	private static int count = 0;
	private static int saleCount = 0;
	
	public static void main(String[] args) {
		/* 제품을 관리하는 프로그램 구현하세요.
		 * 메뉴
		 * 1. 제품 입고
		 *  - 제품을 판매하기 위해 다른 곳에서 제품을 구매
		 * 2. 제품 판매
		 *  - 입고된 제품을 판매
		 * 3. 제품 수정[가격]
		 * 4. 매출 내역 조회
		 * 5. 종료
		 * */
		int menu;
		//반복문 : 프로그램 종료선택전까지
		do {
			//메뉴 출력
			printMenu();
			//메뉴 선택
			menu = scan.nextInt();
			//선택 메뉴에 맞는 기능 실행
			runMenu(menu);
		}while(menu != 5);
		
		//프로그램 종료 안내 문구
		System.out.println("프로그램 종료!");
		
	}

	public static void runMenu(int menu) {
		switch(menu) {
		case 1:
			storeProduct();
			break;
		case 2:
			saleProduct();
			break;
		case 3:
			updateProdcut();
			break;
		case 4:
			printSaleList();
			break;
		case 5:
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}

	private static void printSaleList() {
		//매출 내역 조회
		//반복문 : 전체 매출 내역 조회
		for(int i = 0; i<saleCount; i++) {
			//판매 제품 정보 출력
			saleList[i].print();
		}
	}

	private static void updateProdcut() {
		//제품명 입력
		System.out.print("제품명 : ");
		scan.nextLine();//엔터 처리
		String name = scan.nextLine();
		
		//제품 할인 금액 입력
		System.out.print("금액 : ");
		int salePrice = scan.nextInt();
		
		//일치하는 제품의 할인 금액을 수정
		//반복문 : 등록된 제품 전체
		for(int i = 0; i<count; i++) {
			//제품의 이름과 제품명이 같으면
			if(list[i].equals(name)) {
				//제품의 할인 금액을 수정후 종료
				list[i].updateSalePrice(salePrice);
				return;
			}
		}
		//일치하는 제품이 없다고 출력
		System.out.println("일치하는 제품이 없다고 출력");
	}

	private static void saleProduct() {
		//등록 제품 목록을 출력
		//반복문 : 등록된 제품 전체
		for(int i = 0; i<count; i++) {
			//제품 정보를 출력
			list[i].print();
		}
		//제품명 입력
		System.out.print("제품명 : ");
		scan.nextLine();//엔터 처리
		String name = scan.nextLine();
		
		//판매 개수를 입력
		System.out.print("수량 : ");
		int amount = scan.nextInt();
		
		//기존 제품 수량을 변경
		//반복문 : 등록된 제품 전체
		int index = -1;
		for(int i = 0; i<count; i++) {
			//제품의 제품명과 판매한 제품명이 같으면
			if(list[i].equals(name)) {
				//번지를 index에 저장
				index = i;
			}
		}
		//일치하는 제품이 없으면 
		if(index == -1) {
			//메서드 종료
			System.out.println("일치하는 제품이 없습니다.");
			return;
		}
		
		//제품 수량이 입력한 제품 수량보다 작으면
		if(list[index].getAmount() < amount) {
			//수량이 잘못됐다고 출력
			System.out.println("수량을 확인하세요.");
			//메서드 종료
			return;
		}
		//제품 수량을 변경
		list[index].updateAmount(-amount);
		
		//매출 내역을 위해 판매 제품 리스트에 추가
		//제품 명과 입력된 제품 수량을 이용하여 인스턴스를 생성
		Product tmp = new Product(name, amount, 
				list[index].getBuyPrice(), 
				list[index].getSalePrice());
		//생성된 인스턴스를 판매 제품 리스트에 추가
		saleList[saleCount] = tmp;
		//판매 횟수를 1증가
		saleCount++;
		System.out.println("판매가 등록되었습니다.");
	}

	public static void storeProduct() {
		//제품 정보를 입력
		System.out.print("제품명 : ");
		scan.nextLine();//엔터 처리
		String name = scan.nextLine();
		
		System.out.print("수량 : ");
		int amount = scan.nextInt();
		
		System.out.print("구매 가격 : ");
		int buyPrice = scan.nextInt();
		
		System.out.print("판매 가격 : ");
		int price = scan.nextInt();
		
		
		//일치하는 제품 정보가 있으면 수량을 누적
		for(int i = 0; i<count; i++) {
			if(list[i].equals(name)) {
				list[i].updateAmount(amount);
				return;
			}
		}
		
		//없으면 추가
		list[count] = new Product(name, amount, buyPrice, price);
		count++;
		
		//배열이 다 차면 확장
		if(count == list.length) {
			list = expandList(list);
		}
	}

	/**
	 * 주어진 list를 확장하는 메서드
	 * @param list 확장할 메서드
	 * @return 주어진 list에 크기 10만큼 늘어난 배열을 반환
	 */
	public static Product[] expandList(Product[] list) {
		Product[] tmpList = new Product[list.length + 10];

		System.arraycopy(list, 0, tmpList, 0, list.length);

		return tmpList;
		
	}

	public static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 제품 입고");
		System.out.println("2. 제품 판매");
		System.out.println("3. 제품 수정");
		System.out.println("4. 매출 내역");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}

}








