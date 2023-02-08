import java.util.Scanner;

public class Solution {
	
	static int N;	// map의 크기
	static int[][] map;	// 매개변수로 넘겨주기 싫어서 static 처리
	static int direction;	// 1 : 동, 2 : 남, 3 : 서, 4 : 북
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스 반복
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + "\n");
			N = Integer.parseInt(sc.nextLine());
			map = new int[N][N];
			// index 행과 열, 넣을 수
			if (N == 1) {
				map[0][0] = 1;
			} else if (N == 2){
				int num = 1;
				map[0][0] = num++;
				map[0][1] = num++;
				map[1][1] = num++;
				map[1][0] = num++;
			} else {
				snail(1, 0, 0, 1);
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(map[i][j] + " ");
				}
				sb.append('\n');
			}
		}
		System.out.println(sb);
	}
	
	private static void snail(int direc, int i, int j, int num) {
		if (0 <= i && i < N && 0 <= j && j < N) {
			if (map[i][j] == 0) map[i][j] = num;
			else return;
		} else {
			return;
		}
		
		switch (direc) {
		case 1:
			if (j+1 == N-1 || map[i][j+2] != 0) direc = 2;
			snail(direc, i, j+1, num+1);
			break;
		case 2:
			if (i+1 == N-1 || map[i+2][j] != 0) direc = 3;
			snail(direc, i+1, j, num+1);
			break;
		case 3:
			if (j-1 == 0 || map[i][j-2] != 0) direc = 4;
			snail(direc, i, j-1, num+1);
			break;
		case 4:
			if (map[i-2][j] != 0) direc = 1;
			snail(direc, i-1, j, num+1);
			break;
		}
	}
}
