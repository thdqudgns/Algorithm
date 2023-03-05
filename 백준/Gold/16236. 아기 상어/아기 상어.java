import java.util.*;

public class Main {
	static int N, eat, time, size;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static class Node {
		int x, y, dist;
		public Node(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	static ArrayList<Node> fishes;
	static Queue<Node> q;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				// 아기상어의 위치 정보를 q에 넣고, 그 위치를 0으로 만든다.
				if (map[i][j] == 9) {
					q.offer(new Node(i, j, 0));
					map[i][j] = 0;
				}
			}
		}
		
		eat = 0; 
		time = 0; 
		size = 2;
		
		solve();
	}

	private static void solve() {
		while(true) {
			LinkedList<Node> fish = new LinkedList<>();
			int[][] dist = new int[N][N];
			
			while(!q.isEmpty()) {
				Node cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int nx = cur.x + dx[d];
					int ny = cur.y + dy[d];
					if (nx<0 || ny<0 || nx>=N || ny>=N) continue;
					if (dist[nx][ny] != 0 || map[nx][ny] > size) continue;
					// map의 범위 안에 있고, 아직 아기상어로부터의 거리가 저장되지 않았고, 아기상어보다 작거나 같은 물고기거나 물고기가 없는 공간이라면
					// 아기상어부터 그 공간까지의 거리를 dist에 저장하고, 아기상어의 움직임을 관리하는 q에 넣는다.
					dist[nx][ny] = dist[cur.x][cur.y] + 1; // -> 현재 아기상어의 위치로부터 해당 공간까지의 거리가 1씩 증가하면서 dist에 저장된다.
					q.offer(new Node(nx, ny, dist[nx][ny]));
					// 만약 map[nx][ny]에 아기상어의 크기보다 작은 물고기(==먹이)가 있다면 fish에 저장한다.
					// 그러면 가까운 순서대로 fish에 들어갈 것이다.
					if (1 <= map[nx][ny] && map[nx][ny] <= 6 && map[nx][ny] < size) fish.offer(new Node(nx, ny, dist[nx][ny]));
				}
			}
			
			// 먹이가 없다면, 이때까지 걸린 시간을 반환한다.
			if (fish.size() == 0) {
				System.out.println(time);
				return;
			}
			
			Node curFish = fish.get(0);
			for (Node pick : fish) {
				if (pick.equals(curFish)) continue; // 맨 처음은 넘어가고
				
				// 현재 fish에 저장된 물고기 중에 거리가 가장 가까운 물고기를 curFish에 저장한다. 
				if (curFish.dist > pick.dist) curFish = pick;
				
				// 저장된 curFish와의 거리와 지금 선택한 pick 물고기와의 거리가 같다면
				else if (curFish.dist == pick.dist) {
					
					// 가장 위에 있는 것을 선택하도록 한다. (x값이 작으면 위에 있음)
					// pick이 더 위에 있다면 pick으로 바꾸고, 아니라면 냅둔다.
					if (curFish.x > pick.x) curFish = pick;
					
					// 거리도 같고, 위에 있는 것도 같다면 더 왼쪽(y가 작음)을 선택한다.
					else if (curFish.x == pick.x) curFish = curFish.y > pick.y ? pick : curFish;
				}
			}
			
			// 이렇게 fish에 저장된 물고기 중에서 가장 먼저 먹을 물고기의 정보를 curFish에 저장했다.
			time += curFish.dist; // 그럼 거리만큼 이동시간이 걸리므로 time에 더해준다.
			eat++; // 한 마리 먹었으므로 eat에 +1 해준다.
			map[curFish.x][curFish.y] = 0; // 먹은 물고기의 공간은 0으로 만들어준다.
			
			// 만약 먹은 양이 아기상어의 size와 동일해진다면, size를 하나 늘린다.
			if (eat == size) {
				size++;
				eat = 0; // 먹은 개수는 초기화
			}
			
			// 아기상어의 위치는 먹은 물고기의 위치이므로 q에 넣어준다.
			q.offer(new Node(curFish.x, curFish.y, 0));
		}
	}
}
