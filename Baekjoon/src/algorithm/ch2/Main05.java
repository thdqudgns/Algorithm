package algorithm.ch2;


// 2884번: 알람 시계
import java.util.Scanner;
class Main05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int M = sc.nextInt();
		//45분 ~ 60분 사이일 때는 분만 빼면 된다
		if( 45 <= M && M <=60) System.out.println(H + " " + (M-45));
		//00시이며, 0분~45분 사이일 때는 H는 23으로 두고, 분은 15를 더하면 된다
		else if( H == 0 && 0 <= M && M < 45) System.out.println(23 + " " + (M+15));
		//00시가 아닐 때, 0분~45분 사이일 때는 H는 1을 빼고, 분은 15를 더하면 된다
		else if( H != 0 && 0 <= M && M < 45) System.out.println((H-1) + " " + (M+15));
	}
}
