import java.io.*;
import java.util.*;

public class Solution {
	static int N, M;
	static String res;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()), t = 0;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (t++ < T) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			res = "";
			arr = new int[N+1];
			setArr();
			for (int i = 0; i < M; i++) {	// M번 반복함
				st = new StringTokenizer(br.readLine());
				int order = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				solve(order, a, b);
			}
			sb.append("#" + t + " " + res + "\n");
		}
		System.out.print(sb);
	}
	private static void setArr() {
		for (int i = 0; i < N+1; i++) {
			arr[i] = i;
		}
	}
	private static void solve(int order, int a, int b) {
		if (order == 0) {	// b를 a에 합치기
			union(a, b);
		} else { // order == 1 -> 같은 집합에 있는지 확인하기
			if (check(a, b)) res += "1";
			else res += "0";
		}
	}
	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return;
		arr[bRoot] = aRoot;
	}
	private static boolean check(int a, int b) {
		if (find(a) == find(b)) return true;
		return false;
	}
	private static int find(int i) {
		if (arr[i] == i) return i;
		return arr[i] = find(arr[i]);
	}
}