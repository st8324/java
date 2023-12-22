package day10.word2;

//사전 클래스
public class Dic {
	
	private Word [] list;
	private int count;//저장된 단어 개수
	
	public Dic() {
		this(5);
	}
	public Dic(int size) {
		if(size < 5) {
			size = 5;
		}
		list = new Word[size];
	}
	
	public boolean insertWord(Word word) {
		//중복 단어 없게 하기 위한 반복문
		for(int i = 0; i<count; i++) {
			if(list[i].equals(word)) {
				return false;
			}
		}
		list[count++] = word;
		if(count == list.length) {
			expandWordList();
		}
		return true;
	}
	public boolean updateWord(Word word) {
		//수정하려는 단어의 단어명과 일치하는 객체 검색
		for(int i = 0; i<count; i++) {
			//일치하면 수정
			if(list[i].getWord().equals(word.getWord())) {
				list[i].setMeaning(word.getMeaning());
				return true;
			}
		}
		return false;
	}
	public boolean deleteWord(String word) {
		int index = -1;
		for(int i = 0; i<count; i++) {
			if(list[i].getWord().equals(word)) {
				index = i;
				break;
			}
		}
		if(index == -1) {
			return false;
		}
		count--;
		//한 칸씩 당겨오기
		//현재 배열과 같은 크기의 새 배열을 생성
		Word[] tmpList = new Word[list.length];
		
		//새 배열에 현재 배열을 복붙
		System.arraycopy(list, 0, tmpList, 0, list.length);
		
		//현재 배열에서 index+1번지부터 단어가 있는 마지막 번지까지
		//복사해서 새 배열에 index번지부터 복붙
		System.arraycopy(tmpList, index+1, list, index, count-index);

		return true;
	}
	public void expandWordList() {
		//기존 단어장보다 큰 새 단어장 생성
		Word[] tmpList = new Word[list.length + 10];
		//새 단어장에 기존 단어들을 복붙
		System.arraycopy(list, 0, tmpList, 0, count);
		//새 단어장을 내 단어장이라고 선언
		list = tmpList;
	}
	public void searchWord(String word) {
		for(int i = 0; i<count; i++) {
			if(list[i].equals(word)) {
				list[i].print();
				return;
			}
		}
		System.out.println("일치하는 단어가 없습니다.");
	}
}







