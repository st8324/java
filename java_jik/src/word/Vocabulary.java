package word;

import java.util.ArrayList;
import java.util.List;

import lombok.ToString;

//단어장
@ToString
public class Vocabulary {
	
	private List<Word> list;//단어 리스트

	public Vocabulary(List<Word> list) {
		if(list == null) {
			list = new ArrayList<Word>();
		}
		this.list = list;
	}
	
	//단어 추가 기능
	public boolean addWord(String word, String partOfSpeech, String mean) {
		if(list == null) {
			return false;
		}
		//이미 등록된 단어이고, 뜻도 등록되었으면
		int index = list.indexOf(new Word(word));
		if(index >= 0 && list.get(index).getMeanList().contains(new Mean(mean))) {
			return false;
		}
		//이미 등록된 단어이면
		if(index >= 0) {
			list.get(index).addMean(partOfSpeech, mean);
			return true;
		}
		//새로 추가된 단어이면
		list.add(new Word(word, partOfSpeech, mean));
		
		return true;
	}
	
	//단어 수정 기능
	public boolean setWord(String oldWord, String newWord) {
		
		//list가 없으면
		if(list == null) {
			return false;
		}
		//이미 등록된 단어이면
		if(list.contains(new Word(newWord))) {
			return false;
		}
		//수정할 단어가 없는 단어이면
		int index = list.indexOf(new Word(oldWord));
		if(index < 0) {
			return false;
		}
		//수정
		list.get(index).setWord(newWord);
		return true;
	}
	//단어 삭제 기능
	public boolean removeWord(String word) {
		//리스트가 비어 있으면
		if(list == null) {
			return false;
		}
		//삭제 후 삭제 여부를 리턴
		return list.remove(new Word(word));
	}
}










