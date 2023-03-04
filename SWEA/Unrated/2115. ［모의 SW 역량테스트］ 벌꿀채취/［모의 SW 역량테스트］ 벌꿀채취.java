import java.util.Scanner;

public class Solution {
	static int N, M, C, ans; // 통 크기, 선택할 벌통수, 꿀의 최대 양, 정답
	static int[][] map, profit;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(), t = 0;
		
		while(t++ < T) {
			N = sc.nextInt();
			M = sc.nextInt();
			C = sc.nextInt();
			map = new int[N][N];
			profit = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			setProfit();
			setPosition();
			System.out.printf("#%d %d\n", t, ans);
			ans = 0;
		}
	}

	private static void setPosition() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				
				// 같은 행일 때
				for (int c = j + M; c <= N - M; c++) {
					ans = Math.max(ans, profit[i][j] + profit[i][c]);
				}
				// 다른 행일 때
				for (int r = i + 1; r < N; r++) {
					for (int c = 0; c <= N - M; c++) {
						ans = Math.max(ans, profit[i][j] + profit[r][c]);
					}
				}
			}
		}
	}

	private static void setProfit() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - M; j++) {
				setMaxProfit(i, j, 0, 0, 0);
			}
		}
	}

	private static void setMaxProfit(int i, int j, int cnt, int cSum, int pSum) {
		if (cSum > C) return;
		if (cnt == M) {
			profit[i][j - M] = Math.max(profit[i][j - M], pSum);
			return;
		}
		setMaxProfit(i, j + 1, cnt + 1, cSum, pSum);
		setMaxProfit(i, j + 1, cnt + 1, cSum + map[i][j], pSum + map[i][j] * map[i][j]);
	}
}