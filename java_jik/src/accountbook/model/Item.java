package accountbook.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

//수입 지출 내역
@Data
@AllArgsConstructor
public class Item {
	
	public final static String datePatter = "yyyy-MM-dd";
	
	private Date date;
	private boolean income;//true이면 수입, false이면 지출
	private String category;
	private String contents;
	private int money;
	
	public void setDate(String date) {
		SimpleDateFormat format = new SimpleDateFormat(datePatter);
		try {
			this.date = format.parse(date);
		} catch (ParseException e) {
			this.date = null;
			System.out.println("날짜 형식에 맞지 않습니다.");
		}
	}
	
	//category setter
	public void setCategory(String catetory) {
		//수입이고, 주어진 카테고리가 수입 카테고리가 맞은 경우
		if(income && checkCategory(IncomeCategory.values(), catetory)) {
			this.category = catetory;
			return;
		}
		//지출이고, 주어진 카테고리가 지출 카테고리가 맞은 경우
		if(!income && checkCategory(ExpenseCategory.values(), catetory)) {
			this.category = catetory;
		}
	}
	/* 카테고리 배열이 주어지면 주어진 카테고리가 카테고리 배열에 있는지 확인하는 메서드*/
	public static boolean checkCategory(Object [] categories, String category) {
		//카테고리 리스트가 잘못된 경우
		if(categories == null || categories.length == 0) {
			return false;
		}
		//카테고리가 잘못된 경우
		if(category == null) {
			return false;
		}
		for(Object tmp : categories) {
			if(category.equals(tmp.toString())) {
				return true;
			}
		}
		return false;
	}
}






