import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[] board;
	static int dump, test_case;
	static StringBuilder sb = new StringBuilder();
	static final int MAX = 100;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[MAX+1];

		for (int t = 1; t <= 10; t++) {
			test_case = t;
			dump = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 입력받기
			for (int i = 1; i < MAX+1; i++) {
					board[i] = Integer.parseInt(st.nextToken());
			}
			//정렬하기
			Arrays.sort(board);
			//dump 횟수만큼 숫자 +- 작업하기
			work();
		}
		
		System.out.println(sb);
	}
	
	private static void work() {
		if (dump <= 0 || board[MAX] - board[1] <= 1) {
			sb.append("#" + test_case + " ").append(board[MAX] - board[1]).append('\n');
			return;
		}
		dump--;
		board[MAX]--; 
		board[1]++;
		Arrays.sort(board);
		work();	// 재귀호출
	}
}
