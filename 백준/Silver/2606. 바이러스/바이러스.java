import java.io.*;
import java.util.*;

public class Main {
	static int N, T, cnt;
	static List<List<Integer>> list;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		T = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		visit = new boolean[N+1];
		visit[0] = true;
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.get(x).add(y);
			list.get(y).add(x);
		}
		dfs(1);
		System.out.println(cnt-1);	// 1번 컴퓨터 제외
	}
	private static void dfs(int n) {
		cnt++;
		visit[n] = true;
		for (int i = 0; i < list.get(n).size(); i++) {
			if (visit[list.get(n).get(i)]) continue;
			dfs(list.get(n).get(i));
		}
	}
}
