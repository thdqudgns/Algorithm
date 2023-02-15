import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, R;
	static int[] input, result;
	static LinkedHashSet<String> set;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			set = new LinkedHashSet<>();
			N = Integer.parseInt(st.nextToken());
			if (N == 0) return;
			R = 6;
			input = new int[N];
			result = new int[R];
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			comb(0, 0);
			for(String s : set) {
				System.out.println(s);
			}
			System.out.println();
		}
		
		
	}
	private static void comb(int cnt, int start) {
		if (cnt == R) {
			String tmp = "";
			for (int i = 0; i < R; i++) {
				tmp += String.valueOf(result[i]) + " ";
			}
			set.add(tmp);
			return;
		}
		for (int i = start; i < N; i++) {
			result[cnt] = input[i];
			comb(cnt + 1, i + 1);
		}
	}
}
