package accountbook.service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.LongStream;

import accountbook.model.ExpenseCategory;
import accountbook.model.IncomeCategory;
import accountbook.model.Item;
import accountbook.model.PrintError;

public class PrintServiceImp implements PrintService{

	//스트림에서는 지역 변수를 활용할 수 없음. 지역 상수나 멤버변수를 이용해야 함.
	private int i = 0;
	
	@Override
	public void printMainMenu() {

		System.out.println("-------메뉴-------");
		System.out.println("1. 내역 입력");
		System.out.println("2. 내역 수정");
		System.out.println("3. 내역 삭제");
		System.out.println("4. 내역 조회");
		System.out.println("5. 종료");
		System.out.println("-----------------");
		System.out.print("메뉴 선택 : ");
		
	}

	@Override
	//분류에 맞는 카테고리 출력
	public void printItemCategory(boolean income) {
		if(income) {
			for(IncomeCategory category : IncomeCategory.values()) {
				System.out.print(category + " ");
			}
			System.out.println();
			return;
		}
		for(ExpenseCategory category : ExpenseCategory.values()) {
			System.out.print(category + " ");
		}
		System.out.println();
	}

	@Override
	//날짜와 일치하는 내역을 조회, 년, 년-월, 년-월-일 조회 가능
	public void printItemListByDate(List<Item> list, String date) {
		if(list == null || list.size() == 0) {
			System.out.println("출력할 내역이 없습니다.");
			return;
		}
		//내역에서 날짜가 일치하는지 알려주는 객체
		Predicate<Item> p = item -> item.getDateStr().substring(0, date.length()).equals(date);
		long count = list.stream().filter(p).count();
		//일치하는 내역이 없는 경우
		if(count==0) {
			System.out.println("일치하는 내역이 없습니다.");
			return;
		}
		i = 1;
		list.stream().filter(p).forEach(item->{
			System.out.println(i++ + ". " +item);
		});
	}

	@Override
	public void printSubMenu() {
		System.out.println("------출력메뉴------");
		System.out.println("1. 전체 조회");
		System.out.println("2. 년도별 조회");
		System.out.println("3. 월별 조회");
		System.out.println("4. 일별 조회");
		System.out.println("5. 분류별 조회");
		System.out.println("-----------------");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void printItemListByCategory(List<Item> list, String category) {
		if(list == null || list.size() == 0) {
			System.out.println("출력할 내역이 없습니다.");
		}
		if(!Item.checkExpenseCategory(category) && !Item.checkIncomeCategory(category)) {
			System.out.println("분류를 잘못 입력했습니다.");
			return;
		}
		Predicate<Item> p = (item)->item.getCategory().equals(category);
		long count = list.stream().filter(p).count();
		if(count == 0) {
			System.out.println("출력할 내역이 없습니다.");
			return;
		}
		list.stream().filter(p).forEach(item->System.out.println(item));
	}
}
