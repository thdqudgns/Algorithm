import java.io.*;
import java.util.*;

public class Solution {
	static class BC {
		int r, c, coverage, performance;
		public BC(int r, int c, int coverage, int performance) {
			this.r = r;
			this.c = c;
			this.coverage = coverage;
			this.performance = performance;
		}
	}
	static int distance(BC bc, User user) {
		return Math.abs(bc.r - user.r) + Math.abs(bc.c - user.c);
	}
	/*
	static boolean outRange(int nr, int nc) {
		if (nr<1 || nc<1 || nr>10 || nc>10) return true;
		return false;
	}
	*/
	static int[][] move = {{0, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, 0}};
	static int M, A, ans;
	static int[] u1, u2;
	static class User {
		int r, c;
		public User(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static User user1;
	static User user2;
	static BC[] bcs;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()), t = 0;
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while (t++ < T) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());

			u1 = new int[M+1]; // 0 ~ M-1
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) u1[i] = Integer.parseInt(st.nextToken());
			
			u2 = new int[M+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= M; i++) u2[i] = Integer.parseInt(st.nextToken());
			
			bcs = new BC[A];
			for (int i = 0; i < A; i++) {	// A번 반복, 입력
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int cov = Integer.parseInt(st.nextToken());
				int per = Integer.parseInt(st.nextToken());
				bcs[i] = new BC(r, c, cov, per);
			}
			
			ans = 0;
			user1 = new User(1, 1);
			user2 = new User(10, 10);
			start();
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.print(sb);
	}
	private static void start() {
		/*
		 * 0. (1,1), (10,10) 에서 시작해서, u1, u2를 M초까지 매초마다 move에 따라 움직인다.
		 * 1. 사용자와 배터리를 1대1 대응시키면서, 사용자가 배터리의 cov 안에 있으면 충전시킨다.
		 */
		for (int m = 0; m <= M; m++) {
			user1.r += move[u1[m]][0];
			user1.c += move[u1[m]][1];
			user2.r += move[u2[m]][0];
			user2.c += move[u2[m]][1];
			plusCharge();
		}
	}
	private static void plusCharge() {
		int max = 0;
		/*
		 * user1, user2의 위치마다
		 * 충전가능한 배터리의 조합을 확인하여
		 * 그 때의 충전량을 max에 저장하고
		 * 그 때의 최댓값을 ans에 더한다.
		 */
		for (int a = 0; a < A; a++) {	// A: BC의 개수
			for (int b = 0; b < A; b++) {
				int aSum = getPerformance(a, user1);
				int bSum = getPerformance(b, user2);
				int totalSum;
				// 배터리가 다르다면 각각 더하고, 다를 때의 최댓값을 max에 저장할거다.
				if (a != b) totalSum = aSum + bSum;
				// 배터리가 같다면? -> 더 이득보는 쪽을 더한다.
				else totalSum = bSum;
				// 그 후에 max에 저장
				max = Math.max(totalSum, max);
			}
		}
		ans += max;
		
	}
	/**
	 * user가 bcs[bcIndex] 충전기의 범위 안에 있다면 performace를 반환한다.
	 */
	private static int getPerformance(int bcIndex, User user) {
		return distance(bcs[bcIndex], user) <= bcs[bcIndex].coverage ? 
				bcs[bcIndex].performance : 0;
	}
}