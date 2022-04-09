package algorithm.ch1;


// 2588번 곱셈 일의자리, 십의자리, 백의자리
import java.util.Scanner;
class Main06 {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int A = sc.nextInt();
		 int B = sc.nextInt();
		 System.out.println( A*(B%10) );		//A x 일의자리
		 System.out.println( A*((B/10)%10) );	//A x 십의자리
		 System.out.println( A*(B/100) );		//A x 백의자리
		 System.out.println( A*B );
	}
}