import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int N, R, min;
	static int[] input, numbers, reverse;
	static int[][] map;
	static int[][] sum;
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#" + t + " ");
			N = Integer.parseInt(br.readLine()); // TC마다의 배열크기
			R = N / 2;
			min = Integer.MAX_VALUE;
			map = new int[N][N];
			sum = new int[N][N];
			input = new int[N];
			for (int i = 0; i < N; i++) input[i] = i; 				
			numbers = new int[R];
			input();
			comb(0, 0);
			sb.append(min + "\n");
		}
		System.out.println(sb);
	}
	
	private static void comb(int cnt, int start) {
		if (cnt == R) {
			reverse = new int[R];
			int idx = 0;
			Rev:
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < R; j++) {
					if (input[i] == numbers[j]) continue Rev;
				}
				reverse[idx++] = input[i];
			}
			//System.out.println(Arrays.toString(numbers));
			//System.out.println(Arrays.toString(reverse));
			compare(numbers, reverse);
			return;
		}
		for (int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			comb(cnt + 1, i + 1);
		}
	}

	private static void compare(int[] num, int[] rev) {
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < R; i++) {
			for (int j = i+1; j < R; j++) {
				sum1 += sum[num[i]][num[j]];
				sum2 += sum[rev[i]][rev[j]];
			}
		}
		int res = Math.abs(sum1 - sum2);
		min = Math.min(res, min);
	}

	private static void input() throws IOException {
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (sum[i][j] != 0 || map[i][j] == 0) continue;
				sum[i][j] = map[i][j] + map[j][i];
				sum[j][i] = sum[i][j];
			}
		}
		/*
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(sum[i][j] + " ");
			}
			System.out.println();
		}
		*/
	}
}
