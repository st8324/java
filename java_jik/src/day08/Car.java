package day08;

public class Car {
	//- 정보 : 멤버변수
	//- 무게 : 단위는 톤으로, 브랜드, 분류, 색상, 바퀴 종류, 차명, 년식
	double weight;
	String brand;
	//0:소형, 1:중형, 2:대형, 3:화물, 4:세단
	String category; 
	//0xff0000
	//int color;
	String color;
	String [] tires;
	String carName;
	int year;
	boolean power;//시동
	int speed;//현재 속력
	boolean leftLight;//왼쪽 깜빡이
	boolean rightLight;//우측 깜빡이
	//- 기능 : 메서드
	//- 가속(엑셀을 밟음), 감속(브레이크를 밟음), 시동을 켜기/끄기
	//- 좌측|우측 깜빡이를 켜기/끄기
	
	//시동을 켜기/끄기
	//시동이 꺼져있으면 켜짐, 시동이 켜져있으면 꺼짐
	public void turn() {
		power = !power;
		if(power) {
			System.out.println("시동이 켜졌습니다.");
		}else {
			System.out.println("시동이 꺼졌습니다.");
		}
	}
	//가속
	public void speedUp() {
		speed++;
	}
	//감속
	public void speedDown() {
		speed--;
	}
	//좌측|우측 깜빡이 켜기/끄기, 위:우측1, 가운데0, 아래:좌측-1
	public void turnLight(int direction) {
		switch(direction) {
		case 1:		rightLight = true; 	leftLight = false; 	break;
		case -1:	rightLight = false; leftLight = true; 	break;
		case 0:		rightLight = false; leftLight = false; 	break;
		}
	}

	//자동차 현재 상태를 출력하는 메서드
	public void print() {
		System.out.println("------------------");
		System.out.println("시동 : " + power);
		System.out.println("속력 : " + speed);
		System.out.println("좌깜 : " + leftLight);
		System.out.println("우깜 : " + rightLight);
		System.out.println("------------------");
	}
}








