import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		int bon = Integer.MAX_VALUE;
		if (N % 5 == 0) {
			bon = N / 5;
		} 
		if ((N % 5) % 3 == 0) {
			int tmp = (N / 5) + ((N % 5) / 3);
			bon = tmp < bon ? tmp : bon;
		} 
		if (N % 3 == 0) {
			int tmp = N / 3;
			bon = tmp < bon ? tmp : bon;
		} 
		for (int i = 0; i < N / 5; i++) {
			int tmp = N - 5 * (i + 1);
			if (tmp % 3 == 0) {
				int res = (i + 1) + (tmp / 3);
				bon = res < bon ? res : bon;
			}
		}
		if (bon == Integer.MAX_VALUE) {
			bon = -1;
		}
		System.out.println(bon);
	}
}
