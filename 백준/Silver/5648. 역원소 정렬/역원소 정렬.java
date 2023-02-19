import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong((new StringBuffer(sc.next())).reverse().toString());
		}
		Arrays.sort(arr);
		for(long l : arr) {
			System.out.println(l);
		}
	}
}
