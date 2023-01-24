import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		int i = 666;
		while (true) {
			if (String.valueOf(i).contains("666")) {
				cnt++;
			}
			if (cnt == N) {
				break;
			}
			i++;
		}
		System.out.println(i);
	}
}