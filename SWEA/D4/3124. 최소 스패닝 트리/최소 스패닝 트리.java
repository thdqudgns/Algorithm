import java.io.*;
import java.util.*;

public class Solution {
	static class Vertex implements Comparable<Vertex> {
		int no, cost;
		public Vertex(int no, int cost) {
			this.no = no;
			this.cost = cost;
		}
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	static PriorityQueue<Vertex> pq;
	static int V, E;
	static long ans;
	static boolean[] visited;
	static List<Vertex>[] data;
	static int[] minCost;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()), t = 0;
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while(t++ < T) {
			pq = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			ans = 0;	// 비용을 저장할 변수는 ans로 static으로 선언했다.
			visited = new boolean[V+1];
			data = new List[V+1];	// 정점의 번호를 index로 사용하기 위해 V+1
			minCost = new int[V+1];
			Arrays.fill(minCost, Integer.MAX_VALUE);

			for (int i = 1; i <= V; i++) data[i] = new ArrayList<>(); // 값을 저장할 공간 만들기
			
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				data[from].add(new Vertex(to, cost));
				data[to].add(new Vertex(from, cost));
			}
			
			pq.offer(new Vertex(1, 0));
			minCost[1] = 0;
			
			// 방문한 정점의 개수를 셀 변수.
			int cnt = 0;
			
			// 정점의 수만큼 반복, 시작점은 필요없다.
			while(!pq.isEmpty()) {
				// 현재 최소 비용으로 갈 수 있는 정점으로 간다. -> pq에서 꺼내면 됨
				// 근데 이미 방문한 정점이라면, 다음 최소 비용으로 갈 수 있는 정점에 간다.
				Vertex v = pq.poll();

				if (visited[v.no]) continue;
				
				visited[v.no] = true;
				ans += v.cost;
				
				if (++cnt == V) break;
				
				for (int i = 0; i < data[v.no].size(); i++) {
					if (!visited[data[v.no].get(i).no] 
							&& minCost[data[v.no].get(i).no] > data[v.no].get(i).cost) {
						minCost[data[v.no].get(i).no] = data[v.no].get(i).cost;
						pq.offer(new Vertex(data[v.no].get(i).no, data[v.no].get(i).cost));
					}
				}
			}
			
			sb.append(String.format("#%d %d\n", t, ans));
		}
		System.out.print(sb);
	}
}