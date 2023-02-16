import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, T, cnt;
	static List<List<Integer>> list;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		visit = new boolean[N+1];
		visit[0] = true;
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.get(x).add(y);
			list.get(y).add(x);
		}
		
		for (int i = 1; i <= N; i++) {
			if (visit[i]) continue;
			dfs(i);
			cnt++;
		}
		System.out.println(cnt);	// 1번 컴퓨터 제외
	}
	private static void dfs(int n) {
		if (visit[n]) return;
		visit[n] = true;
		for (int i = 0; i < list.get(n).size(); i++) {
			if (visit[list.get(n).get(i)]) continue;
			dfs(list.get(n).get(i));
		}
	}
}
