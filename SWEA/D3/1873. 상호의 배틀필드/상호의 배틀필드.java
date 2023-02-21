import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int H, W, N;	// 행, 열, 명령어 개수
	static int nowR, nowC;	// 탱크의 현재위치
	static char[][] map;// map
	static char[] order;// 명령어 배열
	static char tank;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// test_case
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			// map 입력
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			for (int h = 0; h < H; h++) {
				map[h] = br.readLine().toCharArray();
				for (int w = 0; w < W; w++) {
					if (map[h][w] == '<' || map[h][w] == '>' || map[h][w] == '^' || map[h][w] == 'v') {
						tank = map[h][w];
						nowR = h;
						nowC = w;
					}
				}
			}
			// order 입력
			N = Integer.parseInt(br.readLine());
			order = new char[N];
			order = br.readLine().toCharArray();
			battle();
			sb.append(String.format("#%d ", t));
			for (int h = 0; h < H; h++) {
				for (int w = 0; w < W; w++) {
					sb.append(map[h][w]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	/**
		문자	의미	map
		.	평지(전차가 들어갈 수 있다.)
		*	벽돌로 만들어진 벽
		#	강철로 만들어진 벽
		-	물(전차는 들어갈 수 없다.)
		^	위쪽을 바라보는 전차(아래는 평지이다.)
		v	아래쪽을 바라보는 전차(아래는 평지이다.)
		<	왼쪽을 바라보는 전차(아래는 평지이다.)
		>	오른쪽을 바라보는 전차(아래는 평지이다.)
		
		문자	동작	order
		U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
		D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
		L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
		R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
		S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
		
		nowR, nowC 탱크의 현재위치
		***....
		*-..#**
		#<.****
		[S, U, R, S, S, S, S, U, S, L, S, R, S, S, S, U, R, R, D, S, R, D, S]
	 */
	private static void battle() {
		// 명령 수행 순서
		for (int o = 0; o < N; o++) {
			if (order[o] == 'S') {
				tankShoot();
			} else if (order[o] == 'U') {
				moveU();
			} else if (order[o] == 'D') {
				moveD();
			} else if (order[o] == 'L') {
				moveL();
			} else if (order[o] == 'R') {
				moveR();
			}
		}
	}

	private static void moveU() {
		tank = '^';
		map[nowR][nowC] = tank;
		if (nowR - 1 < 0) return;
		if (map[nowR-1][nowC] == '.') {
			map[nowR][nowC] = '.';
			nowR -= 1;
			map[nowR][nowC] = tank;
		}
	}

	private static void moveD() {
		tank = 'v';
		map[nowR][nowC] = tank;
		if (nowR + 1 >= H) return;
		if (map[nowR+1][nowC] == '.') {
			map[nowR][nowC] = '.';
			nowR += 1;
			map[nowR][nowC] = tank;
		}
	}

	private static void moveL() {
		tank = '<';
		map[nowR][nowC] = tank;
		if (nowC - 1 < 0) return;
		if (map[nowR][nowC-1] == '.') {
			map[nowR][nowC] = '.';
			nowC -= 1;
			map[nowR][nowC] = tank;
		}
	}

	private static void moveR() {
		tank = '>';
		map[nowR][nowC] = tank;
		if (nowC + 1 >= W) return;
		if (map[nowR][nowC+1] == '.') {
			map[nowR][nowC] = '.';
			nowC += 1;
			map[nowR][nowC] = tank;
		}
	}

	private static void tankShoot() {
		// 탱크가 바라보는 방향으로 포탄을 쏜다.
		// 포탄을 쏠 때는 탱크가 이동하지 않는다.
		int boomRow = nowR;
		int boomCol = nowC;
		
		if (tank == '<') {
			// 포탄이 날아가는 열이 0 이상이며, 벽을 만나지 않는다면 왼쪽으로 계속 이동한다. -> 0보다 작아지거나, 벽을 만나면 멈춘다.
			while (boomCol-1 >= 0 && map[boomRow][boomCol-1] != '*' && map[boomRow][boomCol-1] != '#') {
				boomCol -= 1;
			}
			// 0보다 작아졌다면, 아무일도 일어나지 않으므로 넘어간다.
			if (boomCol-1 < 0) return;
			// * 을 만난다면 부수고 .으로 바꾼다.
			if (map[boomRow][boomCol-1] == '*') {
				map[boomRow][boomCol-1] = '.';
				return;
			}
			// # 을 만난다면 아무일도 일어나지 않는다. 그 외에 평지나 물도 마찬가지
			if (map[boomRow][boomCol-1] == '#') return;
		} else if (tank == '>') {
			// 포탄이 날아가는 열이 W-1 이하이며, 벽을 만나지 않는다면 오른쪽으로 계속 이동한다. -> W-1보다 커지거나, 벽을 만나면 멈춘다.
			while (boomCol+1 <= W-1 && map[boomRow][boomCol+1] != '*' && map[boomRow][boomCol+1] != '#') {
				boomCol += 1;
			}
			// W-1보다 커졌다면, 아무일도 일어나지 않으므로 넘어간다.
			if (boomCol+1 >= W) return;
			// * 을 만난다면 부수고 .으로 바꾼다.
			if (map[boomRow][boomCol+1] == '*') {
				map[boomRow][boomCol+1] = '.';
				return;
			}
			// # 을 만난다면 아무일도 일어나지 않는다. 그 외에 평지나 물도 마찬가지
			if (map[boomRow][boomCol+1] == '#') return;
		} else if (tank == '^') {
			// 포탄이 날아가는 방향이 0 이상이며, 벽을 만나지 않는다면 위쪽으로 계속 이동한다. -> 0보다 작아지거나, 벽을 만나면 멈춘다.
			while (boomRow-1 >= 0 && map[boomRow-1][boomCol] != '*' && map[boomRow-1][boomCol] != '#') {
				boomRow -= 1;
			}
			// 0보다 작아졌다면, 아무일도 일어나지 않으므로 넘어간다.
			if (boomRow-1 < 0) return;
			// * 을 만난다면 부수고 .으로 바꾼다.
			if (map[boomRow-1][boomCol] == '*') {
				map[boomRow-1][boomCol] = '.';
				return;
			}
			// # 을 만난다면 아무일도 일어나지 않는다. 그 외에 평지나 물도 마찬가지
			if (map[boomRow-1][boomCol] == '#') return;
		} else if (tank == 'v') {
			// 포탄이 날아가는 방향이 H-1 이하이며, 벽을 만나지 않는다면 아래쪽으로 계속 이동한다. -> H-1 보다 커지거나, 벽을 만나면 멈춘다.
			while (boomRow+1 <= H-1 && map[boomRow+1][boomCol] != '*' && map[boomRow+1][boomCol] != '#') {
				boomRow += 1;
			}
			// H-1보다 커졌다면, 아무일도 일어나지 않으므로 넘어간다.
			if (boomRow+1 > H-1) return;
			// * 을 만난다면 부수고 .으로 바꾼다.
			if (map[boomRow+1][boomCol] == '*') {
				map[boomRow+1][boomCol] = '.';
				return;
			}
			// # 을 만난다면 아무일도 일어나지 않는다. 그 외에 평지나 물도 마찬가지
			if (map[boomRow+1][boomCol] == '#') return;
		}
	}
}
