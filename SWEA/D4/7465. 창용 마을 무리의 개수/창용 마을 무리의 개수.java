import java.io.*;
import java.util.*;

public class Solution {
	static int[] p;
	static int N, M, res;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()), t = 0;
		StringTokenizer st;
		while(t++ < T) { // TC
			sb.append("#" + t + " ");
			res = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			p = new int[N+1];
			int[] tmp = new int[N+1];
			for (int i = 1; i < N+1; i++) p[i] = i;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			for (int i = 1; i < N+1; i++) {
				tmp[find(i)] = 1;
			}
			res = Arrays.stream(tmp).sum();
			sb.append(res + "\n");
		}
		System.out.print(sb);
	}
	private static void union(int a, int b) {
		int aRoot = find(a);	// a 의 대표를 찾고
		int bRoot = find(b);	// b 의 대표를 찾고
		// 대표가 같다면 넘어가고, 다르다면 합친다.
		if (aRoot == bRoot) return;
		p[bRoot] = aRoot;
	}
	private static int find(int a) {
		if (p[a] == a) return a; // 대표가 일치한다면 반환
		// 대표가 다르다면 상위 대표를 저장하면서 찾아 반환한다.
		return p[a] = find(p[a]);
	}
}
