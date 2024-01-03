package day17;

import lombok.AllArgsConstructor;
import lombok.Data;

public class SynchronizedEx2 {

	public static void main(String[] args) {
		//Synchronized 블록 이용
		BankBook2 bb = new BankBook2(0, "홍길동");
		Customer2 c1 = new Customer2(bb, "홍길동");
		Customer2 c2 = new Customer2(bb, "고길동");
		
		Thread t1 = new Thread(()->{
			c1.deposit(1000);
		});
		Thread t2 = new Thread(()->{
			c2.deposit(1000);
		});
		t1.start();
		t2.start();
	}

}
@AllArgsConstructor
class Customer2{
	private BankBook2 bankBook;
	private String name;
		
	public void deposit(int money) {
		synchronized (bankBook) {
			int balance = bankBook.getBalance();
			bankBook.setBalance(balance+money);
		
			try{
				//2초 동안 현재쓰레드를 일시중지
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name);
			System.out.println(bankBook.getBalance());
		}
	}
}
@Data
@AllArgsConstructor
class BankBook2{
	private int balance;
	private String name;
}

