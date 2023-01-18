import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		final int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int max_height = Integer.MIN_VALUE;
		int min_height = Integer.MAX_VALUE;

		int[][] block = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				block[i][j] = Integer.parseInt(st.nextToken());
				max_height = Math.max(max_height, block[i][j]);
				min_height = Math.min(min_height, block[i][j]);
			}
		}
		/* 입력 확인 완료
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(block[i][j] + " ");
			}
			System.out.println();
		}
		 */

		// 인벤토리에 넣는 작업 2초, 쌓는 작업 1초 걸린다.
		// 땅고르기 최소시간과, 그 경우 땅의 높이를 구하시오.
		
		// 작업을 시작할 때 인벤토리에는 B개의 블록이 들어 있다. 
		// 땅의 높이는 256블록을 초과할 수 없으며, 음수가 될 수 없다.
		
		// 최소시간이 여러 개 있다면 그중에서 땅의 높이가 가장 높은 것을 출력하시오.
		
		// 1. 최대높이로 맞추는 경우 -> 인벤토리에 필요한만큼의 블럭이 있는지 확인하고,
		// 블록을 꺼내는 데 걸리는 시간 (필요한 개수 * 1), 그때의 높이를 출력한다.
		
		// 2. 인벤토리에 블럭이 부족해서 그 다음의 높이로 구하는 경우 -> 그 높이를 기준으로 블럭이 충분한지 확인하고
		// 높은 블럭은 회수함 (시간 = 회수개수 * 2), 낮은 블럭은 인벤토리에서 채움 (시간 = 필요한 개수 * 1)
		
		// 한 블럭 제거하는 시간 = 두 블럭 쌓는 시간
		// 블럭을 제거하는 것보다는 쌓는 것이 우선순위. -> 쌓아서 고르게 할 수 없을 때 블럭 제거

		int min_time = Integer.MAX_VALUE;
		int height = -1;
		
//		System.out.println(time + "초 " + less + " " + height + "로");
//		System.out.println(min_time + " " + height);
		
		// 여기까지는 최소높이 ~ 최대높이를 알게되었다.
		// 이제 높이를 감소시키며, 최소시간을 알아보자.
//		System.out.println(max_height + " " + min_height);
		
		// 최소시간이 같다면, 땅의 높이는 가장 높은 것을 출력해야 하기에, 점점 증가해야한다.
//		for (int h = max_height; h >= min_height; h--) {
		for (int h = min_height; h <= max_height; h++) {
			// h 높이를 맞출때 걸리는 시간이 더 적으면, 최소시간과 높이를 최신화다. (인벤토리 고려)
			int tmp_time = 0;
			int b = B;	//매번 블록 초기화 <-- ★★★이거를 안하고 있었다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(block[i][j] > h) {
						b += (block[i][j] - h);
						tmp_time += 2 * (block[i][j] - h);
					} else if (block[i][j] < h) {
						b -= (h - block[i][j]);
						tmp_time += (h - block[i][j]);
					}	// 어차피 b를 더 쓰게 된다면 밑에서 걸리므로, 중간중간 -값이 되어도 상관없다.
				}
			}
			if (b >= 0) {
				if (tmp_time <= min_time) {
					min_time = tmp_time;
					height = h;
				}
			}
		}
		
		System.out.println(min_time + " " + height);
		
	}
}
