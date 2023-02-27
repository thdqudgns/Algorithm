import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int min1 = 3000;
		int min2 = 3000;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			int tmp = sc.nextInt();
			min1 = Math.min(min1, tmp);
		}
		for (int i = 0; i < 2; i++) {
			int tmp = sc.nextInt();
			min2 = Math.min(min2, tmp);
		}
		System.out.println(min1 + min2 - 50);
	}
}