import java.util.*;
import java.io.*;

public class Main {
	static int N, M, cityLen = Integer.MAX_VALUE;
	static int[][] map;
	static List<int[]> homes = new ArrayList<>();;
	static List<int[]> chickens = new ArrayList<>();;
	static int[][] pick;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		pick = new int[M][];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) homes.add(new int[] {i, j});
				if (map[i][j] == 2) chickens.add(new int[] {i, j});
			}
		}
		
		comb(0, 0);
		
		System.out.println(cityLen);
	}
	private static void comb(int cnt, int start) {
		if (cnt == M) {
			int tmpCityLen = 0;
			// 치킨거리 구하기
			for (int[] home : homes) {
				int chickenLen = Integer.MAX_VALUE;
				for (int[] chicken : pick) {
					int distance = distance(home, chicken);
					chickenLen = Math.min(chickenLen, distance);
				}
				tmpCityLen += chickenLen;
                if (tmpCityLen > cityLen) return;
			}
			cityLen = Math.min(cityLen, tmpCityLen);
			return;
		}
		
		for (int i = start; i < chickens.size(); i++) {
			pick[cnt] = chickens.get(i);
			comb(cnt+1, i+1);
		}
	}
	
	private static int distance(int[] home, int[] chicken) {
		return Math.abs(home[0] - chicken[0]) + Math.abs(home[1] - chicken[1]);
	}
}