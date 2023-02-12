// https://m.blog.naver.com/lm040466/221787478911
// 내 이전 풀이는 왜 틀린 것인가... 조사할 필요가 있다.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 함수에서 사용할 변수들
	static int[][] check; // 간선 연결상태
	static boolean[] checked; // 확인 여부
	static int N; // 정점개수
	static int M; // 간선개수
	static int V; // 시작정점

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		check = new int[N+1][N+1]; // 좌표를 그대로 받아들이기 위해 +1해서 선언
		checked = new boolean[N+1]; // 초기값 False

		// 간선 연결상태 저장
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			check[x][y] = check[y][x] = 1;
		}

		dfs(V); // dfs호출

		checked = new boolean[1001]; // 확인상태 초기화
		System.out.println(); // 줄바꿈

		bfs(); // bfs호출
	}

	// 시작점을 변수로 받아 확인, 출력 후 다음 연결점을 찾아 시작점을 변경하여 재호출
	public static void dfs(int i) {
		checked[i] = true;
		System.out.print(i + " ");

		for (int j = 1; j <= N; j++) {
			if (check[i][j] == 1 && checked[j] == false) {
				dfs(j);
			}
		}
	}

	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(V); // 시작점도 Queue에 넣어야 함
		checked[V] = true;
		System.out.print(V + " ");

		// Queue가 빌 때까지 반복. 방문 정점은 확인, 출력 후 Queue에 넣어 순서대로 확인
		while (!queue.isEmpty()) {
			int temp = queue.poll();

			for (int j = 1; j <= N; j++) {
				if (check[temp][j] == 1 && checked[j] == false) {
					queue.offer(j);
					checked[j] = true;
					System.out.print(j + " ");
				}
			}
		}
	}
}