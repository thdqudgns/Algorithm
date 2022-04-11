package algorithm.ch3;

// 8393번: 합
import java.util.Scanner;
class Main03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		for(int i=1; i<n+1; i++) sum += i;
		System.out.println(sum);
	}
}
