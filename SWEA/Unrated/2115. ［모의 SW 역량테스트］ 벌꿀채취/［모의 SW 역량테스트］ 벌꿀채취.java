import java.util.*;
import java.io.*;

public class Solution {
	static int N, M, C, ans;
	static int[][] map, extract; // 꿀 정보를 저장할 배열, 꿀의 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()), t = 0;
		StringBuilder sb = new StringBuilder();
		while(t++ < T) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			extract = new int[N][N-M+1];
			ans = 0;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			setExtract();
			getMaxResult();
			sb.append(String.format("#%d %d\n", t, ans));
		}
		System.out.println(sb);
	}

	private static void getMaxResult() {
		List<Integer> idxMaxCash = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			idxMaxCash.add(Arrays.stream(extract[i]).max().orElse(0));
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N-M; j++) {
				idxMaxCash.set(i, 0);
				int cur = extract[i][j];
				
				int rowMax = 0;
				int nextRowMax = idxMaxCash.stream().mapToInt(Integer::valueOf).max().orElse(0);
				for (int k = j+M; k <= N-M; k++) {
					rowMax = Integer.max(rowMax, extract[i][k]);
				}
				ans = Math.max(ans, cur + Math.max(rowMax, nextRowMax));
			}
		}
	}

	private static void setExtract() {
		for (int i = 0; i < N; i++) 
			for (int j = 0; j <= N-M; j++)
				// (i, j)에서 채집할 수 있는 최대 가격을 저장한다.
				extract[i][j] = getCost(i, j);
	}

	private static int getCost(int x, int y) {
		int[] cur = new int[M]; // 벌통을 선택하여 임시 저장할 배열
		System.arraycopy(map[x], y, cur, 0, M); // map[x] 배열의 y열부터 M개의 값들을 -> cur배열의 0 index부터 저장한다.
		
		int maxCost = Integer.MIN_VALUE;
		// M개의 원소들의 부분집합 중에서, 채집 가능한 최댓값을 반환한다.
		for (int i = 0; i < (1<<M); i++) {
			// 하나의 부분집합 상황마다
			int cnt = 0;	// 꿀의 양 저장
			int square = 0; // 꿀의 가격 저장
			for (int j = 0; j < M; j++) {
				if ((i&1<<j) == 0) continue; // 0이면 부분집합에서 제외
				cnt += cur[j];
				square += cur[j]*cur[j]; // 가격은 양의 제곱이다.
			}
			// cnt와 square에 부분집합별 꿀의 양과 가격이 저장되었다. 이제 그 중에 최대값을 반환하자.
			if (cnt > C) continue;
			maxCost = Math.max(maxCost, square);
		}
		return maxCost;
	}
}