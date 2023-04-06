import java.io.*;
import java.util.*;

public class Main {
	static int N, All, V, answer = Integer.MAX_VALUE;
	static int[][] inputMap, dist;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[] idx, select;
	static List<Virus> viruses = new ArrayList<>();
	static boolean can = false; // dist에 -1이 없다면 true 저장
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		inputMap = new int[N][N];
		
		// -2 벽, -1 빈칸, 0 바이러스, 자연수 : 퍼진 시간
		dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(dist[i], -1);
			for (int j = 0; j < N; j++) {
				// 0 빈칸, 1 벽, 2 바이러스
				inputMap[i][j] = Integer.parseInt(st.nextToken());
				// 바이러스가 올 수 있는 자리 배열 
				if (inputMap[i][j] == 2) viruses.add(new Virus(i, j));
				// 벽 만들기
				if (inputMap[i][j] == 1) dist[i][j] = -2; // 바이러스는 조합 이후에 0으로 적용
			}
		}

		All = viruses.size();
		idx = new int[All];
		select = new int[V];
		for (int i = 0; i < All; i++) idx[i] = i; 
		/*
		 *  바이러스 수 : All = viruses.size()
		 *  바이러스를 놓을 수 있는 수 : V
		 *  dist에서 0: 바이러스 시작 위치, -1: 빈칸, 자연수: 도달시간
		 *  퍼뜨린 후에 -1이 있다면, can이 false 그대로이기에, can이 false라면 -1 출력
		 *  다 퍼뜨렸으면 그때의 시간은 dist의 최댓값으로 answer를 최소로 갱신
		 *  
		 *  1. 0 ~ All 중에서 V 개를 선택하는 조합을 뽑는다. 이때의 0 ~ All은 viruses의 index가 된다.
		 *  2. 선택된 V개 만큼의 index에 저장된 바이러스의 위치를 0으로 만들고, Queue에 넣어 BFS를 시작한다.
		 *  3. BFS를 돌면서, dist가 -2인 부분과 index가 넘어가는 부분은 continue하고, 만약 dist[nr][nc] >= 0 이라면 이미 방문한 곳이므로 넘어간다. 
		 *  4. 나머지는 dist[nr][nc] = dist[r][c] + 1 한다. == 방문처리됨, Queue에 nr, nc를 넣는다.
		 */
		comb(0, 0);
		
		if (!can) System.out.print(-1);
		else System.out.print(answer);
		
	}
	
	private static void solve(int[] select, int[][] dist) {
		/* 
		 * dist
		 * -2: 벽
		 * -1: 빈칸
		 * 0: 바이러스
		 * 자연수: 퍼진 시간
		 */
		Queue<int[]> q = new ArrayDeque<>();
		for(int idx : select) {
			Virus get = viruses.get(idx);
			dist[get.r][get.c] = 0;
			q.offer(new int[] {get.r, get.c});
		}
		
		while(!q.isEmpty()) {
			int[] get = q.poll();
			int r = get[0], c = get[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (outOfRange(nr, nc)) continue; // 범위 밖
				if (dist[nr][nc] == -2 || dist[nr][nc] >= 0) continue; // 벽, 이미 방문한 곳
				dist[nr][nc] = dist[r][c] + 1;
				q.offer(new int[] {nr, nc});
			}
		}
		
		// -1과 최솟값 체크
		int time = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (dist[i][j] == -1) return;
				if (dist[i][j] > time) time = dist[i][j];
			}
		}
		
		answer = Math.min(answer, time);
		can = true;
		
	}

	private static boolean outOfRange(int nr, int nc) {
		return nr<0 || nc<0 || nr>=N || nc>=N;
	}

	private static void comb(int cnt, int start) {
		if (cnt == V) {
			int[][] copyDist = copyDist();
			solve(select, copyDist);
			return;
		}
		for (int i = start; i < All; i++) {
			select[cnt] = idx[i];
			comb(cnt+1, i+1);
		}
	}
	
	private static int[][] copyDist() {
		int[][] copy = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = dist[i][j];
			}
		}
		return copy;
	}
}


class Virus {
	int r, c;
	public Virus(int r, int c) {
		this.r = r;
		this.c = c;
	}
}