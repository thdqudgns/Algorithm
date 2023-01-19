import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int A = sc.nextInt();
		final int B = sc.nextInt();
		final int C = sc.nextInt();
		
		final int G = A * B * C;
		String s = String.valueOf(G);
//		System.out.println(s);
		
		int[] numbers = new int[10];
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i)-'0';
			numbers[index]++;
		}
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}
}