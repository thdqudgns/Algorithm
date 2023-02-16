import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(sc.nextLine());
			sb.append("#"+t+"\n");
			map = new int[N][N];
			snail();
		}
		System.out.println(sb);
	}
	private static void snail() {
		int num = 1;
		int x = 0, y = 0;
		int d = 0;
		while(num <= N*N) {
			map[x][y] = num;
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] != 0) d = (d+1) % 4;
			x += dx[d];
			y += dy[d];
			num++;
		}
		print();
	}
	private static void print() {
		for (int[] row : map) {
			Arrays.stream(row).forEach(x -> sb.append(x + " "));
			sb.append("\n");
		}
	}
}
