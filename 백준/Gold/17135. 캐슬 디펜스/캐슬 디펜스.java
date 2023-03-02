import java.util.*;

public class Main {
	static class Enemy {
		int r, c;
		public Enemy(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int N, M, D, ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		List<Enemy> enemies = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (sc.nextInt() == 1) enemies.add(new Enemy(i, j));
			}
		}
		
		for (int i = 0; i < M - 2; i++) {
			for (int j = i+1; j < M - 1; j++) {
				for (int k = j+1; k < M; k++) {
					List<Enemy> copyEnemies = new LinkedList<>();
					for (Enemy e : enemies) copyEnemies.add(new Enemy(e.r, e.c));
					
					killEnemies(copyEnemies, new int[] {i,j,k});
				}
			}
		}
		System.out.println(ans);
	}
	private static void killEnemies(List<Enemy> copyEnemies, int[] archers) {
		int cnt = 0;
		while (!copyEnemies.isEmpty()) {
			Set<Enemy> removeEnemies = new HashSet<>();
			for (int archer : archers) {
				Enemy e = findEnemy(copyEnemies, archer);
				if (e != null) {
					removeEnemies.add(e);
				}
			}
			cnt += removeEnemies.size();
			copyEnemies.removeAll(removeEnemies);
			downEnemy(copyEnemies);
		}
		ans = Math.max(ans, cnt);
	}
	private static Enemy findEnemy(List<Enemy> copyEnemies, int archer) {
		int minD = 1 << 30, minC = 50;
		Enemy find = null;
		for (Enemy e : copyEnemies) {
			int d = N - e.r + Math.abs(archer - e.c);
			if (d > D || d > minD) continue;
			
			if (d < minD) {
				minD = d;
				minC = e.c;
				find = e;
				continue;
			}
			
			if (minC > e.c) {
				minC = e.c;
				find = e;
			}
		}
		return find;
	}
	private static void downEnemy(List<Enemy> copyEnemies) {
		Iterator<Enemy> ite = copyEnemies.iterator();
		while (ite.hasNext()) {
			Enemy e = ite.next();
			e.r++;
			if (e.r == N) ite.remove();
		}
		
	}
}
