package algorithm.ch2;


// 2753번: 윤년
import java.util.Scanner;
class Main03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		if( (A%4 == 0 && A%100 != 0) || A%400 == 0) System.out.println("1");
		else System.out.println("0");
	}
}
