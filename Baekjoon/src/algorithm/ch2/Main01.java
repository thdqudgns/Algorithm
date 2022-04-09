package algorithm.ch2;


// 1330번: 두 수 비교하기 
import java.util.Scanner;
class Main01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		if(A > B) System.out.println(">");
		else if(A < B) System.out.println("<");
		else if(A== B) System.out.println("==");
	}
}
