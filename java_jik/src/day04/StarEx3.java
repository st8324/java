package day04;

public class StarEx3 {

	public static void main(String[] args) {
		/*     * i=1	' '=4	*=1	
		 *    ** i=2	' '=3	*=2
		 *   *** i=3	' '=2	*=3
		 *  **** i=4	' '=1	*=4
		 * ***** i=5	' '=0	*=5
		 * 				' '=5-i	*=i개
		 */
		int rows = 5;
		for(int i = 1; i <= rows; i++) {
			//' '을 5-i개 출력
			for(int j = 1; j<=rows-i; j++) {
				System.out.print(' ');
			}
			
			//*을 i개 출력
			for(int j = 1; j<=i; j++) {
				System.out.print("*");
			}
			
			//엔터
			System.out.println();
		}

	}

}
