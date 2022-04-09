package algorithm.ch2;


// 14681번: 사분면 고르기
import java.util.Scanner;
class Main04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		if(x>0 && y>0) System.out.println("1");
		else if(x<0 && y>0) System.out.println("2");
		else if(x<0 && y<0) System.out.println("3");
		else if(x>0 && y<0) System.out.println("4");
	}
}
