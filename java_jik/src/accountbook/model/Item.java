package accountbook.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import accountbook.exception.CategoryException;
import lombok.Data;

//수입 지출 내역
@Data
public class Item implements Serializable{
	
	private static final long serialVersionUID = -4434398397116622128L;
	
	private boolean income; //수입이면 true, 지출이면 false
	private Date date;  //날짜
	private String category;//분류
	private int money;//금액
	private String content;//내용
	public final static String datePatter = "yyyy-MM-dd";//날짜 포맷
	//날짜가 문자열로 왔을 때 처리하는 setter
	public void setDate(String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(datePatter);
		this.date = format.parse(date);
	}
	//날짜를 문자여롤 가져오는 메서드. 기본 getter 아님
	public String getDateStr() {
		return new SimpleDateFormat(datePatter).format(date);
	}
	//카테고리가 열거형에 있는 카테고리가 맞으면 저장, 아니면 예외 발생
	public void setCategory(String category) throws CategoryException {
		//수입이고, 수입 카테고리가 맞으면
		if(income && checkIncomeCategory(category)) {
			this.category = category;
			return;
		}
		//지출이고 지출 카테고리가 맞으면
		if(!income && checkExpenseCategory(category)) {
			this.category = category;
			return;
		}
		//잘못된 카테고리이면 : 수입인데 지출카테고리이거나 지출인데 수입 카테고리이거나 없는 카테고리이면
		throw new CategoryException();
	}
	//지출 카테고리가 맞는지 확인
	public static boolean checkExpenseCategory(String category) {
		for(ExpenseCategory eCategory : ExpenseCategory.values()) {
			//열거형을 문자열로 바꾼후 카테고리와 비교
			if(eCategory.toString().equals(category)) {
				return true;
			}
		}
		return false;
	}
	//수입 카테고리가 맞는지 확인
	public static boolean checkIncomeCategory(String category) {
		for(IncomeCategory iCategory : IncomeCategory.values()) {
			if(iCategory.toString().equals(category)) {
				return true;
			}
		}
		return false;
	}
	//카테고리 체크 때문에 생성자를 직접 정의함
	public Item(boolean income, String date, String category, int money, String content) throws CategoryException, ParseException {
		this.income = income;
		setDate(date);
		//카테고리 추가 시 확인이 필요
		setCategory(category);
		this.money = Math.abs(money);
		this.content = content;
	}
	//유효한 날짜가 맞는지 확인하는 '클래스' 메서드
	public static boolean checkDate(String date) {
		SimpleDateFormat format = new SimpleDateFormat(datePatter);
		try {
			format.parse(date);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
	public String toString() {
		return getDateStr() + " : " + (income?"[수입]" : "[지출]") + "\n"
			+ "분류 : " + category + "\n"
			+ "금액 : " + money + "\n"
			+ "내용 : " + content;
	}
}
