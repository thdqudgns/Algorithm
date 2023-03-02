import java.util.*;
import java.io.*;

public class Main {
	static class Vertex implements Comparable<Vertex> {
		int num, cost;
		public Vertex(int num, int cost) {
			this.num = num;
			this.cost = cost;
		}
		@Override
		public int compareTo(Vertex o) {
			// 가중치(비용)의 오름차순으로 PQ를 정렬할 거다.
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	static List<Vertex>[] data;
	static PriorityQueue<Vertex> pq;
	static boolean[] visited;
	static int V, E, ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		
		int start = Integer.parseInt(br.readLine())-1;
		data = new List[V];
		for (int i = 0; i < V; i++) {
			data[i] = new ArrayList<Vertex>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			data[from-1].add(new Vertex(to-1, cost));
		}
		
		pq = new PriorityQueue<>();
		pq.offer(new Vertex(start, 0));
		
		final int INF = Integer.MAX_VALUE;
		int[] distance = new int[V];
		boolean[] visited = new boolean[V];
		
		Arrays.fill(distance, INF);
		distance[start] = 0;
		int min, current, cnt = 0;
		while (!pq.isEmpty()) {
			Vertex minVt = pq.poll();
			if (visited[minVt.num]) continue;

			current = minVt.num;
			min = minVt.cost;
			visited[current] = true;
			
			for (Vertex v : data[current]) {
				if (!visited[v.num]
						&& distance[v.num] > min + v.cost) {
					distance[v.num] = min + v.cost;
					pq.offer(new Vertex(v.num, distance[v.num]));
				}
			}
		}
		
		for (int i = 0; i < V; i++) {
			sb.append(distance[i] != INF ? distance[i] + "\n" : "INF\n");
		}
		
		System.out.print(sb);
	}
}
