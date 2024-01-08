package word.service;

public class PrintServiceImp implements PrintService {

	@Override
	public void printMainMenu() {
		System.out.println("--------메뉴--------");
		System.out.println("1. 단어 관리");
		System.out.println("2. 뜻 관리");
		System.out.println("3. 게임");
		System.out.println("4. 종료");
		System.out.println("-------------------");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void printWordMenu() {
		System.out.println("------단어 메뉴------");
		System.out.println("1. 단어 추가");
		System.out.println("2. 단어 수정");
		System.out.println("3. 단어 삭제");
		System.out.println("4. 이전으로");
		System.out.println("-------------------");
		System.out.print("메뉴 선택 : ");
		
	}

	@Override
	public void printMeanMenu() {
		System.out.println("------의미 메뉴------");
		System.out.println("1. 의미 추가");
		System.out.println("2. 의미 수정");
		System.out.println("3. 의미 삭제");
		System.out.println("4. 이전으로");
		System.out.println("-------------------");
		System.out.print("메뉴 선택 : ");
	}

}
