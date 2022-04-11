package algorithm.ch3;

// 10950번: A+B-3
import java.util.Scanner;
class Main02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] A = new int[T]; //입력한 만큼 공간을 만들어줘야 한다
		int[] B = new int[T];
		sc.nextLine();
		for(int i = 0; i<T; i++) {
			A[i] = sc.nextInt();
			B[i] = sc.nextInt();
		}
		
		for(int i = 0; i<T; i++) {
			System.out.println(A[i]+B[i]);
		}
		
	}
}
