import java.util.*;

public class Solution {
	static class Vertex implements Comparable<Vertex> {
		int r, c, cost;
		public Vertex(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	static int V;
	static PriorityQueue<Vertex> pq;
	static int[][] minDist; // == minCost
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		int t = 0;
		while (t++ < T) {
			V = Integer.parseInt(sc.nextLine());
			minDist = new int[V][V];
			map = new int[V][V];
			visited = new boolean[V][V];
			pq = new PriorityQueue<>();
			
			for (int i = 0; i < V; i++) {
				String s = sc.nextLine();
				for (int j = 0; j < V; j++) {
					map[i][j] = s.charAt(j) - '0';
				}
				Arrays.fill(minDist[i], Integer.MAX_VALUE);
			}
			
			minDist[0][0] = 0;
			pq.offer(new Vertex(0, 0, 0));
			
			while(!pq.isEmpty()) {
				Vertex v = pq.poll();
				if (visited[v.r][v.c]) continue;
				
				visited[v.r][v.c] = true;
				if (v.r == V-1 && v.c == V-1) break;
				
				// 현재 위치를 기준으로 사방탐색하면서, 갱신시킬 게 있는지 확인
				for (int d = 0; d < 4; d++) {
					int nr = v.r + dr[d];
					int nc = v.c + dc[d];
					if (nr<0 || nc<0 || nr>=V || nc>=V) continue;
					if (minDist[nr][nc] > v.cost + map[nr][nc]) {
						minDist[nr][nc] = v.cost + map[nr][nc];
						pq.offer(new Vertex(nr, nc, minDist[nr][nc]));
					}
				}
			}
			System.out.printf("#%d %d\n", t, minDist[V-1][V-1]);
		}
	}
}
