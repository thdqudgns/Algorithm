import java.io.*;
import java.util.*;

public class Solution {
	static int N, W, H, ans;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()), t = 0;
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while (t++ < T) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			ans = Integer.MAX_VALUE;
			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 구슬을 깨고 남은 벽돌의 최솟값을 구한다
			solve(0, map); // 구슬을 사용한 횟수, 어디서 떨어뜨릴지 위치 (0 ~ W-1)
			sb.append(String.format("#%d %d\n", t, ans));
		}
		System.out.print(sb);
		
	}
	private static void solve(int cnt, int[][] map) {
		if (cnt == N) {
			int cntStone = 0;
			for (int[] row : map) for (int n : row) if (n > 0) cntStone++;
			ans = Math.min(ans, cntStone);
			return;
		}
		
		for (int i = 0; i < W; i++) {
			int[][] copyMap = new int[H][W];
			for (int r = 0; r < H; r++) {
				copyMap[r] = Arrays.copyOf(map[r], W);
			}
			solve(cnt + 1, breaking(i, copyMap));
		}
	}
	private static int[][] breaking(int col, int[][] copyMap) {
		int row = 0;
		int range = 0;
		for (int i = 0; i < H; i++) {
			if (copyMap[i][col] != 0) {
				row = i;
				range = copyMap[i][col];
				break;
			}
		}
		// row, col : 벽돌이 깨지기 시작하는 위치
		// range : 깨지는 범위
		breakStone(row, col, range, copyMap);
		return downStone(copyMap);
	}
	private static void breakStone(int row, int col, int range, int[][] copyMap) {
		if (row<0 || row>=H || col<0 || col>=W) return;
		copyMap[row][col] = 0;
		// row가 증가할 때, col은 유지된다.
		for (int r = row - range + 1; r < row + range; r++) {
			if (r<0 || r>=H || copyMap[r][col] == 0) continue;
			if (copyMap[r][col] == 1) copyMap[r][col] = 0;
			if (copyMap[r][col] > 1) breakStone(r, col, copyMap[r][col], copyMap);
		}
		// col이 변할 때, row는 유지된다.
		for (int c = col - range + 1; c < col + range; c++) {
			if (c<0 || c>=W) continue;
			if (copyMap[row][c] == 1) copyMap[row][c] = 0;
			if (copyMap[row][c] > 1) breakStone(row, c, copyMap[row][c], copyMap);
		}
	}
	private static int[][] downStone(int[][] copyMap) {
		//열마다 벽돌을 내려준다.
		for (int w = 0; w < W; w++) {
			List<Integer> keep = new ArrayList<>();
			for (int h = 0; h < H; h++) {
				if (copyMap[h][w] != 0) keep.add(copyMap[h][w]);
				copyMap[h][w] = 0;
			}
			int h = H-1;
			int index = keep.size()-1;
			while (h>=0) {
				if (index < 0) break;
				copyMap[h--][w] = keep.get(index--);
			}
		}
		return copyMap;
	}
}
