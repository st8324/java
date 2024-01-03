package day17;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class IpEx1 {

	public static void main(String[] args) {
		InetAddress address = null;
		
		try {
			//localhost는 내부 IP를 의미하고, 모든 PC가 동일
			address = InetAddress.getByName("localhost");
			System.out.println(address);
			
			//네이버의 아이피 주소 중 하나를 조회
			address = InetAddress.getByName("www.naver.com");
			System.out.println(address);
			
			//내 PC의 아이피 주소를 조회
			address = InetAddress.getLocalHost();
			System.out.println(address);
			
			//네이버의 아이피 주소들을 조회
			InetAddress [] addressList = InetAddress.getAllByName("www.naver.com");
			Arrays.stream(addressList).forEach(addr->System.out.println(addr));
			
		} catch (UnknownHostException e) {
			System.out.println("해당하는 이름과 일치하는 IP정보를 찾을 수 없습니다.");
		}

	}

}
