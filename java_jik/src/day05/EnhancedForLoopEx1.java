package day05;

public class EnhancedForLoopEx1 {

	public static void main(String[] args) {
		//1부터 5까지 저장된 배열을 향상된 for문으로 출력하는 예제
		int arr[] = new int[] {1,2,3,4,5};
		
		for(int i = 0; i<arr.length; i++) {
			int tmp = arr[i];
			System.out.print(tmp + " ");
		}
		System.out.println();
		//향상된 for문 이용
		for(int tmp : arr) {
			System.out.print(tmp + " ");
		}
		System.out.println();
	}

}










