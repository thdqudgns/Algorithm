import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] board = new int[101];
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {

			int dump = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 입력받기
			for (int i = 1; i < 101; i++) {
					board[i] = Integer.parseInt(st.nextToken());
			}
			
			//정렬하기
			Arrays.sort(board);
			
			//dump 횟수만큼 숫자 +- 작업하기
			while(dump > 0) {
				dump--;
				board[100]--; 
				board[1]++;
				//정렬하기
				Arrays.sort(board);
			}
			sb.append("#").append(t).append(" ").append(board[100] - board[1]).append('\n');
		}
		System.out.println(sb);
	}
}
