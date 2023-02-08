import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static StringBuilder sb = new StringBuilder();
	static int N, K, R;	// 재료의 개수, 제한 칼로리, 조합의 개수
	static int[] score, kcal;
	static int[][] combination;	// 0 : 재료 점수, 1 : 칼로리
	static int scoreMax = 0;
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("data/input5215.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 케이스의 개수를 입력받고, 그만큼 반복한다.
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// 재료의 개수
			K = Integer.parseInt(st.nextToken());	// 원재의 칼로리 제한
			scoreMax = 0;
			// 재료 점수, 칼로리를 저장할 배열을 따로 만들어보았다.
			score = new int[N];
			kcal = new int[N];
			// N개의 재료에 대한 점수와 칼로리를 입력받는다.
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i] = Integer.parseInt(st.nextToken());
				kcal[i] = Integer.parseInt(st.nextToken());
			}
			
			/*
			 * 칼로리 제한을 넘지 않는 조합 중에서, 점수가 최대인 것을 찾는다.
			 * -> 중복은 없으며, 순서도 없는 조합이다. 
			 * 조합 개수의 제한도 없어서 1~N개의 조합을 찾는다.
			 */
			sb.append("#" + t + " ");
			for (int i = 1; i <= N; i++) {
				R = i;
				combination = new int[R][2];
				comb(0, 0);
			}
			sb.append(scoreMax).append('\n');
		}
		System.out.println(sb);
	}
	// 조합을 돌면서, 칼로리가 제한을 넘지 않을 때, scoreMax를 구한다.
	private static void comb(int cnt, int start) {
		if (cnt == R) {
			int tmpS = 0;	// 점수 합 구해보기
			int tmpK = 0;	// 칼로리 합 구해보기
			for (int i = 0; i < R; i++) {
				tmpS += combination[i][0];	// 점수
				tmpK += combination[i][1];	// 칼로리
			}
			if (tmpK <= K) {	// 칼로리의 제한을 넘지 않는다면
				scoreMax = Math.max(scoreMax, tmpS);
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			combination[cnt][0] = score[i];
			combination[cnt][1] = kcal[i];
			comb(cnt + 1, i + 1);
		}
		
	}
}
