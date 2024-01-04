package day18.student2;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student2 implements Serializable{

	private static final long serialVersionUID = 1234567890123456780L;
	
	private int grade, classNum, num;
	private String name;
	
	@Override
	public int hashCode() {
		return Objects.hash(classNum, grade, num);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student2 other = (Student2) obj;
		return classNum == other.classNum && grade == other.grade && num == other.num;
	}
	
	@Override
	public String toString() {
		return "[" + grade + "학년 " + classNum + "반 " + num + "번 " + name + "]";
	}
	
}
