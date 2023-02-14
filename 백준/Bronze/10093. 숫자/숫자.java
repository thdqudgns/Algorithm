import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long x = sc.nextLong();
		long y = sc.nextLong();
		long a = Math.min(x, y);
		long b = Math.max(x, y);
		StringBuilder sb = new StringBuilder();
		if (a != b) {
			System.out.println(b - a - 1);
		} else {
			System.out.println(0);
		}
		for (long i = a + 1; i < b; i++) {
			sb.append(i + " ");
		}
		System.out.println(sb);
	}
}
