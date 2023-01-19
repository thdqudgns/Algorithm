import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final String A = sc.next();
		final String B = sc.next();
		
		int a = 0;
		int b = 0;
		int c = 1;
		
		for (int i = 0; i < 3; i++) {
			a += (A.charAt(i)-'0') * c;
			b += (B.charAt(i)-'0') * c;
			c *= 10;
		}
		
		System.out.println(a > b ? a : b);
		
	}
}