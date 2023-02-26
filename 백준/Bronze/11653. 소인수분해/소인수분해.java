import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		divide(n);
	}

	private static void divide(int n) {
		int num = n;
		for (int i = 2; i <= n; i++) {
			if (num == 1 || num == 0) break;
			if (num % i == 0) {
				while(num%i == 0) {
					num /= i;
					System.out.println(i);
				}
			}
		}
	}
}
