package day11.homework;

public class HomeworkEx3 {

	public static void main(String[] args) {
		/* 사이트에서 회원 관리(로그인, 회원가입 등)를 위한 Member 클래스를 작성하세요.*/
		
		//작성한 Member 클래스를 이용하여 인스턴스를 생성하고 구현한 메서드를 테스트해보세요.
		//아이디와 비번이 없는 인스턴스 생성
		Member mem1 = new Member();
		mem1.print();
		//아이디와 비번이 없는 인스턴스이기 때문에 아이디 abc와 비번 def로 비교하면 false
		System.out.println(mem1.equals("abc", "def"));
		
		//아이디가 abc, 비번이 def, 이메일이 abc@naver.com인 인스턴스 생성
		Member mem2 = new Member("abc","def","abc@naver.com");
		mem2.print();
		System.out.println(mem2.equals("abc", "def"));
	}

}
class Member{
	//필요한 멤버변수 및 메서드를 정리하고 구현하세요.
	//멤버변수 : 아이디, 비번, 이메일
	private String id, pw, email;
	//getter,setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//equals : 아이디, 비번이 주어지면 내 정보와 같은지 다른지 알려주는 메서드
	public boolean equals(String id, String pw) {
		
		//아이디가 없으면
		if(this.id == null) {
			return false;
		}
		//비번이 없으면
		if(this.pw == null) {
			return false;
		}
		//아이디와 비번이 일치하면
		if(this.id.equals(id) && this.pw.equals(pw)) {
			return true;
		}
		return false;
	}
	//회원 정보를 출력하는 메서드
	public void print() {
		System.out.println("아이디 : " + id);
		System.out.println("이메일 : " + email);
		System.out.println("비밀번호: " + pw);
	}
	
	//생성자 : 기본생성자, 아이디, 비번, 이메일이 필요한 생성자, 아이디, 비번이 필요한 생성자
	public Member() {}

	public Member(String id, String pw, String email) {
		this.id = id;
		this.pw = pw;
		this.email = email;
	}

	public Member(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	
}










