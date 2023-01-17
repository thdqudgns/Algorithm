import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Main m = new Main();
        System.out.print(m.factorial(n)/m.factorial(n-k)/m.factorial(k));
    }
	
	public int factorial(int a) {
		int result = 1;
		for (int i = 2; i <= a; i++) {
			result *= i;
		}
		return result;
	}
}