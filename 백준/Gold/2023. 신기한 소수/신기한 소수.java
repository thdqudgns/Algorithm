import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] s = {2, 3, 5, 7};
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for(int num : s) {
			check(num, 1);
		}
		System.out.println(sb);
	}
	
	private static void check(int num, int length) {
		if (length == N) {
			sb.append(num).append("\n");
		}
		
		for (int i = 0; i <= 9; i++) {
			int tmp = (num * 10) + i;
			if (isPrime(tmp)) check(tmp, length + 1);
		}
	}

	static boolean isPrime(int num) {
		for (int i = 2; i*i <= num; i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
}
