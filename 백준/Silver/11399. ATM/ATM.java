import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] atm = new int[N];
		for (int i = 0; i < N; i++) {
			atm[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(atm);
		int sum = 0;
		int tmp = 0;
		for (int time : atm) {
			tmp += time;
			sum += tmp;
		}
		System.out.println(sum);
	}
}
