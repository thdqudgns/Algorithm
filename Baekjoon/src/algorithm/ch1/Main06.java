package algorithm.ch1;


// 2588�� ���� �����ڸ�, �����ڸ�, �����ڸ� ������
import java.util.Scanner;
class Main06 {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int A = sc.nextInt();
		 int B = sc.nextInt();
		 System.out.println( A*(B%10) );		//A x �����ڸ�
		 System.out.println( A*((B/10)%10) );	//A x �����ڸ�
		 System.out.println( A*(B/100) );		//A x �����ڸ�
		 System.out.println( A*B );
	}
}