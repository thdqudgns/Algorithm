import java.util.*;

public class Main {
	
	static int N, K, ans = 1;
	
	static void Josephus() {
		for (int i = 1; i <= N; i++) {
			ans = (ans + K - 1) % i + 1;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		Josephus();
		
		System.out.print(ans);
	}
}