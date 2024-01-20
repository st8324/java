package accountbook.service;

import java.util.List;

import accountbook.model.Item;

public interface FileService {

	List<Item> load(String fileName);

	boolean save(String fileName, List<Item> list);

}
