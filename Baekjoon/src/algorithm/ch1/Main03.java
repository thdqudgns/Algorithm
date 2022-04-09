package algorithm.ch1;


// 10926번 ??!
import java.util.Scanner;

//첫번째 풀이: 입력받은 id가 joonas와 동일하면 뒤에 ??!를 출력하도록 함 -> 틀림
//class Main03 {
//	public static void main(String[] args) {
//		 Scanner sc = new Scanner(System.in);
//		 System.out.print(">> 아이디 입력: ");	//여기가 문제임
//		 String A = sc.nextLine();
//		 
//		 if(A.equals( "joonas" ) )	//꼭 joonas일 필요 없음. 그냥 입력받은 값 뒤에 ??!만 붙이면 됨
//			 System.out.println( A + "??!" );
//	}
//}

//두번째 풀이: 입력받은 id뒤에 ??!를 붙임 -> 틀림
//class Main03 {
//	public static void main(String[] args) {
//		 Scanner sc = new Scanner(System.in);
//		 System.out.print(">> 아이디 입력: "); //여기가 문제임
//		 String A = sc.nextLine();
//		 System.out.println( A + "??!" );	//입력받자마자 ??!를 붙이게 수정
//	}
//}
//

//세번째 풀이: 입력받을 때 ">> 아이디 입력: "를 지우고, 입력받자마자 ??!를 붙여서 출력 -> 정답!!
// 입력받을 때 문자가 있으면 안되는 문제였다.
class Main03 {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 String A = sc.nextLine();
		 System.out.println( A + "??!" );
	}
}