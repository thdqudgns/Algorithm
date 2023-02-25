import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int F = sc.nextInt();	// 총 F층
		int S = sc.nextInt();	// 강호가 있는 곳
		int G = sc.nextInt();	// 목적층
		int U = sc.nextInt();	// U층 올라감
		int D = sc.nextInt();	// D층 내려감
		
		int[] floor = new int[F+1];	// -1: 아직 안 간 층
		Arrays.fill(floor, -1);
		floor[S] = 0;
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(S);
		while(!q.isEmpty()) {
			if (floor[G] != -1) break;
			int f = q.poll();
			for (int go : new int[] {f+U, f-D}) {
				if (go<1 || go>F) continue;
				if (floor[go] != -1) continue; //방문했으면 넘어감
				floor[go] = floor[f] + 1;
				q.offer(go);
			}
		}
		if (floor[G] == -1) {
			System.out.println("use the stairs");
		} else {
			System.out.println(floor[G]);
		}
	}
}
