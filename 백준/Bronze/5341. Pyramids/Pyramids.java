import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			long n = sc.nextLong();
			if (n == 0) return;
			System.out.println(n*(n+1)/2);
		}
	}
}