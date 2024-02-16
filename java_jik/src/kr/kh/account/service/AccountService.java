package kr.kh.account.service;

import java.util.List;

import kr.kh.account.model.vo.Category;
import kr.kh.account.model.vo.Item;
import kr.kh.account.model.vo.Type;
import kr.kh.account.pagination.Criteria;

public interface AccountService {

	List<Type> getTypeList();

	List<Category> getCategoryList(String type);

	boolean insertItem(Item item);

	List<Item> getItemListByDate(String date);

	List<Item> getItemListByDate(Criteria cri);

	boolean updateItem(Item item);
	
	boolean deleteItem(int it_num);

}
