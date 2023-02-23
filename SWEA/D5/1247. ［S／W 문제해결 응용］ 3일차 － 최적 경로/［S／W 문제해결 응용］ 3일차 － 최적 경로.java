import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N, min;
	static int[] company, home;
	static int[][] customer;
	static boolean[] visit;
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			input();
			min = Integer.MAX_VALUE;
			solve(company, 0, 0);
			sb.append(String.format("#%d %d\n", t, min));
		}
		System.out.println(sb);
	}

	private static void solve(int[] start, int sum, int cnt) {
		if (cnt == N) {
			sum += dis(start, home);
			min = Math.min(sum, min);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (visit[i]) continue;
			
			visit[i] = true;
			solve(customer[i], sum + dis(start, customer[i]), cnt + 1);
			visit[i] = false;
		}
	}

	private static int dis(int[] start, int[] end) {
		return Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]);
	}

	private static void input() throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int cx = Integer.parseInt(st.nextToken());
		int cy = Integer.parseInt(st.nextToken());
		int hx = Integer.parseInt(st.nextToken());
		int hy = Integer.parseInt(st.nextToken());
		company = new int[]{cx, cy};
		home = new int[]{hx, hy};
		customer = new int[N][2];
		visit = new boolean[N];
		for (int i = 0; i < N; i++) {
			customer[i][0] = Integer.parseInt(st.nextToken());
			customer[i][1] = Integer.parseInt(st.nextToken());
		}
		//System.out.println(Arrays.toString(company));
		//System.out.println(Arrays.toString(home));
		//System.out.println(Arrays.deepToString(customer));
	}
}
