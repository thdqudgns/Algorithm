//https://st-lab.tistory.com/145
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, max = 0;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (o1, o2) -> {
			//// 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.
			if (o1[1] == o2[1]) {
				return o1[0] - o2[0];
			} else {
				return o1[1] - o2[1];
			}
		});
		/*
		for (int[] num : arr) {
			System.out.println(num[0] + " : " + num[1]);
		}
		*/
		int cnt = 0;
		int end = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i][0] >= end) {
				cnt++;
				end = arr[i][1];
			}
			//solve(i, arr[i][0], arr[i][1], 1);
		}
		System.out.println(cnt);
	}
	/*
	private static void solve(int index, int startTime, int endTime, int cnt) {
		for (int i = index+1; i < N; i++) {
			max = Math.max(cnt, max);
			if (endTime > arr[i][0]) continue;
			solve(i, arr[i][0], arr[i][1], cnt + 1);
		}
	}
	*/
}
