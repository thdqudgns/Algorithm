import java.io.*;
import java.util.*;

public class Main {
	static class Edge implements Comparable<Edge> {
		int from, to, cost;
		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	static int V, E;
	static int[] parents;
	static Edge[] edges;
	
	static void makeSet() {
		for (int i = 0; i < V; i++) parents[i] = i;
	}
	
	static int findSet(int a) {
		if (parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		parents = new int[V];
		edges = new Edge[E];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(from-1, to-1, cost); 
		}
		Arrays.sort(edges);
		makeSet();
		long ans = 0;
		int cnt = 0;
		
		for (Edge e : edges) {
			if (union(e.from, e.to)) {
				ans += e.cost;
				if (++cnt == V-1) break;
			}
		}
		
		System.out.print(ans);
	}
}
