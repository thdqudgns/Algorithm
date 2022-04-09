package algorithm.ch2;


// 9498번: 시험 성적
import java.util.Scanner;
class Main02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		if(90 <= A && A <= 100) System.out.println("A");
		else if(80 <= A) System.out.println("B");
		else if(70 <= A) System.out.println("C");
		else if(60 <= A) System.out.println("D");
		else System.out.println("F");
	}
}
