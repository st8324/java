package day18.student2;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StudentManager {
	
	private List<Student2> list = new ArrayList<Student2>();

	public StudentManager(List<Student2> list) {
		if(list == null) {
			return;
		}
		this.list = list;
	}

	public boolean insertStudent(Student2 std) {
		//중복체크
		if(list.contains(std)) {
			return false;
		}
		//아니면 추가
		list.add(std);
		return true;
	}
	
	public void printStudent() {
		list.stream().forEach(s->System.out.println(s));
	}

	public boolean updateStudent(Student2 std) {
		//등록된 학생인지 확인
		int index = list.indexOf(std);
		//등록된 학생이 아니면 false를 리턴
		if(index < 0) {
			return false;
		}
		//등록된 학생이면 이름을 수정
		list.get(index).setName(std.getName());
		return true;
	}
	
}
