package kr.kh.account.model.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Item {

	int it_num; 
	int it_ca_num; 
	Date it_date; 
	int it_money; 
	String it_content;
	String it_ca_name;
	String it_ty_name;
	
	public Item(int categoryNum, String date, int money, String content, String type) throws ParseException {
		it_ca_num = categoryNum;
		it_money = money;
		it_content = content;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		it_date = format.parse(date);
		it_ty_name = type;
	}
	
	public String getIt_date_str() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(it_date);
	}
	
	@Override
	public String toString() {
		return "[" + it_num + "] " + getIt_date_str() 
			+ "[" + it_ty_name + "] [" + it_ca_name + "]"
			+ " " + it_content + " : " + it_money;
	}

	public Item(int it_num) {
		this.it_num = it_num;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return it_num == other.it_num;
	}

	@Override
	public int hashCode() {
		return Objects.hash(it_num);
	}
	
}





