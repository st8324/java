package accountbook.service;

import java.util.List;

import accountbook.model.Item;

public class AccountBookServiceImp implements AccountBookService{


	@Override
	public boolean insertItem(List<Item> list, Item item) {
		if(list == null) {
			return false;
		}
		if(item == null) {
			return false;
		}
		return list.add(item);
	}

	@Override
	public void sort(List<Item> list) {
		if(list == null || list.size() == 0) {
			return;
		}
		list.sort((i1, i2)->{
			//날짜가 다르면 
			if(i1.getDate().equals(i2.getDate())) {
				return i1.getDate().compareTo(i2.getDate());
			}
			//날짜가 같고, 수입/지출이 다르면
			if(i1.isIncome() != i2.isIncome()) {
				return i1.isIncome() == true ? 1 : -1;
			}
			//날짜가 같고, 수입/지출이 같고, 카테고리가 다르면
			if(i1.getCategory().equals(i2.getCategory())) {
				return i1.getCategory().compareTo(i2.getCategory());
			}
			//위가 다 같으면 내역순으로
			return i1.getContent().compareTo(i2.getContent());
		});
	}

	@Override
	public boolean checkIndex(List<Item> list, int index) {
		if(list == null || list.size() == 0) {
			return false;
		}
		return index >= 0 && index <  list.size();
	}

	@Override
	public boolean updateItem(List<Item> list, int index, Item item) {
		if(list == null || list.size() == 0) {
			return false;
		}
		//수정할 내역이 없으면
		if(item == null) {
			return false;
		}
		//유효하지 않은 번지이면, 컨트롤러에서도 체크했지만 컨트롤러와 별개로 검사해야함.
		if(!checkIndex(list, index)) {
			return false;
		}
		list.remove(index);//기존 내역 삭제 후
		list.add(item);//수정 내역 추가
		return true;
	}

	@Override
	public boolean deleteItem(List<Item> list, int index) {
		if(list == null || list.size() == 0) {
			return false;
		}
		//번지 체크
		if(!checkIndex(list, index)) {
			return false;
		}
		//삭제
		return list.remove(index) != null;
	}

}
