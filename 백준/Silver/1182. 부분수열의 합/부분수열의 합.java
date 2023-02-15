import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, S, num;
	static int[] input;
	static boolean[] selected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		input = new int[N];
		selected = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) input[i] = Integer.parseInt(st.nextToken());
		subset(0);
		if (S == 0) num -= 1;
		System.out.println(num);
	}
	private static void subset(int cnt) {
		if (cnt == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if(!selected[i]) continue;	
				sum += input[i];
			}
			if (sum == S) num++;
			return;
		}
		selected[cnt] = true;
		subset(cnt + 1);
		selected[cnt] = false;
		subset(cnt + 1);
	}
}
