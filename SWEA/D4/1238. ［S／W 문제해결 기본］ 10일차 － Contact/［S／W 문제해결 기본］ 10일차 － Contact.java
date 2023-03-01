import java.io.*;
import java.util.*;

public class Solution {
	/**
	 * 정점 방문 레벨과, 해당 정점의 번호를 저장할 클래스
	 * @author Hun
	 *
	 */
	static class Vertex implements Comparable<Vertex>{
		int level, no;
		public Vertex(int level, int no) {
			this.level = level;
			this.no = no;
		}
		// level, no가 큰 순서로 내림차순 정렬
		@Override
		public int compareTo(Vertex o) {
			if (this.level == o.level) return o.no - this.no;
			return o.level - this.level;
		}
	}
	/**
	 * 정점끼리의 연결 정보를 저장할 연결리스트
	 */
	static List<Integer>[] map;
	/**
	 * 각 정점의 방문여부를 체크할 배열
	 */
	static boolean[] visited;
	/**
	 * BFS를 위한 큐 생성
	 */
	static Queue<Vertex> q;
	/**
	 * 정점 정보를 저장할 배열
	 */
	static List<Vertex> vertexs;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		// TC
		for (int t = 1; t <= 10; t++) {
			// 간선 쌍, 시작점 입력받기
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			// TC마다 map, visited 초기화
			map = new List[101];
			for (int i = 1; i < 101; i++) map[i] = new LinkedList<>();
			visited = new boolean[101];
			vertexs = new ArrayList<>();
			// 간선 연결정보 입력 -> N/2
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				map[from].add(to);
			}
			// BFS 시작
			q = new ArrayDeque<>();	// queue 생성
			q.offer(new Vertex(0, start));	// 시작점 부여
			vertexs.add(new Vertex(0, start));
			visited[start] = true;	// 방문처리
			bfs();
			Collections.sort(vertexs); // 정렬
			System.out.print(String.format("#%d %d\n", t, vertexs.get(0).no));
		}
	}

	private static void bfs() {
		while(!q.isEmpty()) {
			Vertex v = q.poll();
			for (int i = 0; i < map[v.no].size(); i++) {
				if (visited[map[v.no].get(i)]) continue;
				visited[map[v.no].get(i)] = true;
				q.offer(new Vertex(v.level + 1, map[v.no].get(i)));
				vertexs.add(new Vertex(v.level + 1, map[v.no].get(i)));
			}
		}
	}
}
