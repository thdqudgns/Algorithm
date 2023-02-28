import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int a = Math.abs((N-1)/4 - (M-1)/4);
		int b = Math.abs((N-1)%4 - (M-1)%4);
		System.out.println(a+b);
	}
}
