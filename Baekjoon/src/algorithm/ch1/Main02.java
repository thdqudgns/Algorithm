package algorithm.ch1;


//Scanner로 키보드로 입력받을 준비를 하고, 변수에 저장한 후 사칙연산자로 계산한다
import java.util.Scanner;

// 1000번 A+B
class Main02 {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 System.out.print(">>");
		 int A = sc.nextInt();
		 System.out.print(">>");
		 int B = sc.nextInt();
		 
		 System.out.println(A+B);
		 
	}

}

// 1001번 A-B
//class Main02 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.print(">>");
//		int A = sc.nextInt();
//		System.out.print(">>");
//		int B = sc.nextInt();
//		System.out.println(A-B);
//	}
//}

// 10998번 AxB
//class Main02 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.print(">>");
//		int A = sc.nextInt();
//		System.out.print(">>");
//		int B = sc.nextInt();
//		System.out.println(A*B);
//	}
//}

// 1008번 A/B - 소수점도 나오도록 실수로 형변환 해야한다
//class Main02 {
//	public static void main(String[] args) {
//		 Scanner sc = new Scanner(System.in);
//		 System.out.print(">>");
//		 double A = sc.nextDouble();
//		 System.out.print(">>");
//		 double B = sc.nextDouble();
//		 System.out.println(A/B);		 
//	}
//}

// 10869번 사칙연산
//class Main02 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.print(">>");
//		int A = sc.nextInt();
//		System.out.print(">>");
//		int B = sc.nextInt();
//		System.out.println(A+B);
//		System.out.println(A-B);
//		System.out.println(A*B);
//		System.out.println(A/B);
//		System.out.println(A%B);
//	}
//}

