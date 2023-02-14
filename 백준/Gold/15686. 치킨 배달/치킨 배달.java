import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, C, H;
	static int min = Integer.MAX_VALUE;
	static int[][] map;
	static List<int[]> chicken = new ArrayList<>();
	static int[][] pickChicken;
	static List<int[]> house = new ArrayList<>();;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];	// 1부터 담기 시작함
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) chicken.add(new int[] {i, j}); 
				if(map[i][j] == 1) house.add(new int[] {i, j}); 
			}
		}
		/*
		for (int i = 0; i < chicken.size(); i++) {
			System.out.println(chicken.get(i)[0] + " " + chicken.get(i)[1]);
		}
		*/
		C = chicken.size();
		//System.out.println("C: " + C);
		
		//System.out.println();
		/*
		for (int i = 0; i < house.size(); i++) {
			System.out.println(house.get(i)[0] + " " + house.get(i)[1]);
		}
		*/
		H = house.size();
		//System.out.println("H: " + H);
		pickChicken = new int[C][2];
		
		comb(0, 0);
		
		System.out.println(min);
	}
	
	private static void comb(int cnt, int start) {
		if (cnt == M) {
			/*
			for (int i = 0; i < M; i++) {
				System.out.println(Arrays.toString(pickChicken[i]));
			}
			*/
			// 거리측정하기
			int len = 0;
			for (int x = 0; x < H; x++) { // 집마다, 치킨집까지의 거리 계산
				int hL = Integer.MAX_VALUE;
				for (int y = 0; y < M; y++) {
					int tmp = 0;
					tmp += Math.abs(house.get(x)[0] - pickChicken[y][0]);
					tmp += Math.abs(house.get(x)[1] - pickChicken[y][1]);
					//System.out.println(tmp);
					hL = Math.min(tmp, hL);
				}
				len += hL;
			}
			min = Math.min(len, min);
			return;
		}
		
		for (int i = start; i < C; i++) {
			pickChicken[cnt] = chicken.get(i);
			comb(cnt + 1, i + 1);
		}
	}
}
