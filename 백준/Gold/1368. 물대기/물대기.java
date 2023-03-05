import java.io.*;
import java.util.*;

public class Main {
	static int N, ans;
	static int[] p;
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
	static List<Edge> edges;
	static int[] selfCost;
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) return false;
		p[b] = a;
		return true;
	}
	
	static int find(int a) {
		if (p[a] == a) return a;
		return p[a] = find(p[a]);
	}
	
	static void make() {
		for (int i = 0; i < N; i++) {
			p[i] = i;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()) + 1;
		
		selfCost = new int[N];
		for (int i = 1; i < N; i++) {
			selfCost[i] = Integer.parseInt(br.readLine());
		}
		
		edges = new ArrayList<>();
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N; j++) {
				int cost = Integer.parseInt(st.nextToken());
				if (i == j) continue;
				else edges.add(new Edge(i, j, cost));
			}
			edges.add(new Edge(0, i, selfCost[i]));
		}
		
		p = new int[N];
		make();
		
		Collections.sort(edges);
		int cnt = 0;
		
		for(Edge e : edges) {
			if (union(e.from, e.to)) {
				ans += e.cost;
				if (++cnt == N - 1) break;
			}
		}
		
		System.out.println(ans);
	}
}