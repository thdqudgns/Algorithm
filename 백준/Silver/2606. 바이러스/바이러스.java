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
		/*
		int idx = 0;
		for(List<Integer> l : list) {
			System.out.print("idx " + idx++ + ": ");
			for (int i : l) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		*/
		dfs(1);
		System.out.println(cnt-1);	// 1번 컴퓨터 제외
	}
	private static void dfs(int n) {
		if (visit[n]) return;
		cnt++;
		visit[n] = true;
		for (int i = 0; i < list.get(n).size(); i++) {
			if (visit[list.get(n).get(i)]) continue;
			dfs(list.get(n).get(i));
		}
	}
}
