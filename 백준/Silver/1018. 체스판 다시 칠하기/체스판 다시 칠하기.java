import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int cnt = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[][] board = new String[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = String.valueOf(input.charAt(j));
			}
		}
		
		/*
		 * 출력 확인
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		 */

		// --------- 입력 끝 ----------
		
		/*
		 * 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다. 
		 * 당연히 8*8 크기는 아무데서나 골라도 된다. 
		 * 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.
		 */
		
		// 1. 8 * 8 만큼 순회할 수 있는 시작점들을 모두 찾는다 : N - 8, M - 8 이다.
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				// 2. 각 시작점에서부터  8 * 8 만큼 순회하면서, BW가 아닌 개수를 센다. -> 메소드 처리
				//System.out.println("------------------------");
				//System.out.println("i : " + i + ", j : " + j);
				//System.out.println("------------------------");
				foundBoard(board, i, j);
			}
		}
		System.out.println(cnt);
	}
	
	private static void foundBoard(String[][] board, int i, int j) {
		// 8 * 8 만큼 순회하면서 BW가 아닌 개수를 세고, cnt 보다 작으면 최신화한다.
		if (board[i][j].equals("B")) {
			int tmpB = 0;	// BW가 아닌 개수를 셈 - B로 시작할 때
			int tmpW = 0;	// BW가 아닌 개수를 셈 - B로 시작할 때
			int xx = 0;
			int yy = 0;
			for (int x = i; x < i + 8; x++) {
				yy = 0;
				for (int y = j; y < j + 8; y++) {
					//System.out.println("x : " + x + ", y : " + y);
					// B로 시작할 때 - 짝수행의 짝수번째와 홀수행의 홀수번째가 W면 tmpB + 1 
					if (xx % 2 == 0 && yy % 2 == 0 && board[x][y].equals("W")) {
						tmpB++; 
					} else if (xx % 2 == 1 && yy % 2 == 1 && board[x][y].equals("W")) {
						tmpB++;
					} else if (xx % 2 == 0 && yy % 2 == 1 && board[x][y].equals("B")) {
						tmpB++; 
					} else if (xx % 2 == 1 && yy % 2 == 0 && board[x][y].equals("B")) {
						tmpB++;
					} else {
						tmpW++;
					}
					//System.out.println("tmpB : " + tmpB);
					//System.out.println("tmpW : " + tmpW);
					yy++;
				}
				xx++;
			}
			int tmp = tmpB < tmpW ? tmpB : tmpW;
			cnt = tmp < cnt ? tmp : cnt;
		}
		// W로 시작할 때 - 짝수행의 짝수번째와 홀수행의 홀수번째가 B면 tmpW + 1
		if (board[i][j].equals("W")) {
			int tmpB = 0;	// BW가 아닌 개수를 셈 - W로 시작할 때
			int tmpW = 0;	// BW가 아닌 개수를 셈 - W로 시작할 때
			int xx = 0;
			int yy = 0;
			for (int x = i; x < i + 8; x++) {
				yy = 0;
				for (int y = j; y < j + 8; y++) {
					if (xx % 2 == 0 && yy % 2 == 0 && board[x][y].equals("B")) {
						tmpW++; 
					} else if (xx % 2 == 1 && yy % 2 == 1 && board[x][y].equals("B")) {
						tmpW++;
					} else if (xx % 2 == 0 && yy % 2 == 1 && board[x][y].equals("W")) {
						tmpW++; 
					} else if (xx % 2 == 1 && yy % 2 == 0 && board[x][y].equals("W")) {
						tmpW++;
					} else {
						tmpB++;
					}
					//System.out.println("tmpB : " + tmpB);
					//System.out.println("tmpW : " + tmpW);
					yy++;
				}
				xx++;
			}
			int tmp = tmpB < tmpW ? tmpB : tmpW;
			cnt = tmp < cnt ? tmp : cnt;
		}
		//System.out.println("cnt : " + cnt);
	}
	
}
