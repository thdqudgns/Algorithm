import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[1001][1001];
		
		// 색종이 정보를 입력받으면서, n번째 색종이의 영역을 표시하기
		for (int n = 1; n <= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			
			// y축을 기준으로 시작해야, 2차원 배열의 행렬에 맞는다.
			// y가 0일때 -> 가로행 먼저 입력됨
			for (int i = sy; i < sy + height; i++) {
				for (int j = sx; j < sx + width; j++) {
					board[i][j] = n;
				}
			}
		}
		
		// 입력을 다 받은 후, n번째 색종이의 영역을 통해 면적 구하기
		int[] area = new int[N+1];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				area[board[i][j]]++;
			}
		}
		
		for (int r = 1; r < area.length; r++) {
			System.out.println(area[r]);
		}
	}
}