import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextLine().length();
		int b = sc.nextLine().length();
		if (a>=b) System.out.println("go");
		else System.out.println("no");
	}
}