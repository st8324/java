package accountbook.service;

import java.util.List;

import accountbook.model.Item;

public interface PrintService {

	void printMainMenu();

	void printItemCategory(boolean income);

	void printItemListByDate(List<Item> list, String date);

	void printSubMenu();

	void printItemListByCategory(List<Item> list, String category);

}
