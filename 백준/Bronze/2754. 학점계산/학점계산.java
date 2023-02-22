import java.util.Scanner;

public class Main {
	static double score;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		if (s.equals("F")) {
			System.out.println("0.0");
			return;
		}
		score(s.charAt(0));
		plus(s.charAt(1));
		System.out.println(score);
	}
	private static void score(char c) {
		switch (c) {
		case 'A':
			score = 4;
			break;
		case 'B':
			score = 3;
			break;
		case 'C':
			score = 2;
			break;
		case 'D':
			score = 1;
			break;
		}
	}
	private static void plus(char c) {
		switch (c) {
		case '+':
			score += 0.3;
			break;
		case '-':
			score -= 0.3;
			break;
		}
	}
}