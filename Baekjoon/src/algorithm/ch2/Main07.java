package algorithm.ch2;

// 2480번: 주사위 세개
import java.util.Scanner;
class Main07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		if(num1==num2 && num2==num3) System.out.println(num1*1000+10000);
		else if((num1==num2 && num1!=num3)) System.out.println(num1*100+1000);
		else if(num2==num3 && num2!=num1) System.out.println(num2*100+1000);
		else if(num3==num1 && num3!=num2) System.out.println(num3*100+1000);
		else if(num1!=num2 && num2!=num3) {
			if(num1/num2 > 0 && num1/num3 > 0) System.out.println(num1*100);
			if(num2/num3 > 0 && num2/num1 > 0) System.out.println(num2*100);
			if(num3/num1 > 0 && num3/num2 > 0) System.out.println(num3*100);
		}
	}
}