import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int I = 0, J = 0, max = 0;
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				int in = sc.nextInt();
				if (in >= max) {
					I = i; 
					J = j;
					max = in;
				}
			}
		}
		System.out.println(max);
		System.out.print(I + " " + J);
	}
}