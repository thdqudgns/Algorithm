package algorithm.ch3;


// 2739번: 구구단
import java.util.Scanner;
class Main01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i<9; i++) {
			System.out.println(N + " * " + (i+1) + " = " + N*(i+1));
		}
	}
}
