package word.service;

import java.util.List;

import word.Word;

public interface FileService {

	List<Word> load(String fileName);

	boolean save(String fileName, List<Word> list);

}
