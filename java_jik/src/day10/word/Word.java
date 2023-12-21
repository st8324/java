package day10.word;

/*
 * - Word 클래스
 *   - word : 영단어
 *   - meaning : 뜻
 *   - 단어 출력, 단어 수정, 
 *   - 단어 확인 : 주어진 문자열과 같은 단어인지 확인
 */
public class Word {

	private String word;
	private String meaning;
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	
	/**단어와 뜻을 출력하는 기능
	 * */
	public void print() {
		System.out.println(word + " : " + meaning);
	}
	
	/**뜻이 주어지면 뜻을 수정하는 기능
	 * @param meaning 수정할 뜻
	 */
	public void update(String meaning) {
		this.meaning = meaning;
	}
	/**단어가 주어지면 주어진 단어와 내 단어가 같은지 다른지를 알려주는 메서드
	 * @param word 같은지 다를지를 확인할 단어
	 * @return 주어진 word와 내 word가 같으면 true, 다르면 false 리턴
	 */
	
	public boolean equals(String word) {
		return this.word.equals(word);
	}
	//주어진 단어와 뜻으로 단어와 뜻을 초기화 하는 생성자
	public Word(String word, String meaning) {
		this.word = word;
		this.meaning = meaning;
	}
}
