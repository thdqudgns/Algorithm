import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int b = sc.nextInt();
			int a = sc.nextInt();
			sc.nextLine();
			if (a == 0 && b == 0) return;
			if (a>=b) System.out.println("No");
			else System.out.println("Yes");
		}
	}
}