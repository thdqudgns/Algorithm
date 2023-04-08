import java.util.*;
import java.io.*;

/**
 * 위상정렬 문제
 * 진입차수 indegree가 0인 것을 큐에 넣는다.
 * 큐에서 빼내고, 빼낸 정점과 연결된 정점들의 진입차수를 1 갑소시킨다.
 * 
 * 필요한 것 : 
 * - 정점별 진입차수를 관리할 배열 (빼내면 -1로 표시?)
 * - 정점간 연결 정보
 * - 진입차수가 0인 정점을 보관할 큐
 * - 큐에서 빼낸 정점을 저장할 answer 배열
 * 
 * @author Hun
 *
 */
public class Main {
	static int N, M;
	static int[] indegree; // N
	static List<Integer>[] connect; // 1차: N -> 2차: 연결개수만큼
	static Queue<Integer> q;
	static List<Integer> answer; // N
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 학생 수
		M = Integer.parseInt(st.nextToken()); // 정보 수
		indegree = new int[N+1];
		connect = new List[N+1];
		for (int i = 1; i < N+1; i++) connect[i] = new ArrayList<>();
		q = new ArrayDeque<>();
		answer = new ArrayList<>();
		
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 진입차수 관리
			indegree[b]++;
			// 연결정보 관리
			connect[a].add(b); // a -> b
		}
		
		// 진입차수가 0인 정점을 큐에 넣기
		for (int i = 1; i < N+1; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
				indegree[i] = -1; // 넣었으면 -1로
			}
		}
		
		while(!q.isEmpty()) {
			// 진입차수가 0인 정점을 큐에서 빼고, 연결된 간선을 지우고, 정점의 진입차수를 -1 한다.
			int out = q.poll();
			answer.add(out);
			
			for (int i = connect[out].size()-1; i >=0 ; i--) {
				indegree[connect[out].get(i)]--;
				// 진입차수가 0인 정점을 큐에 넣기
				if(indegree[connect[out].get(i)] == 0) {
					q.offer(connect[out].get(i));
					indegree[connect[out].get(i)] = -1; // 넣었으면 -1로
				}
				connect[out].remove(i);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int n : answer) {
			sb.append(n).append(" ");
		}
		System.out.print(sb);
	}
}
