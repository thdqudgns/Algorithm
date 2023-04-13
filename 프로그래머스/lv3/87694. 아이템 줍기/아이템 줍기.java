class Solution {
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] map;
	static boolean[][] visited;
	static int er, ec, ans = Integer.MAX_VALUE;
	
	public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 좌표를 두배로 늘리기
		map = new int[101][101];
		visited = new boolean[101][101];
        
        /*
         *  행이 Y고, 열이 X다.
         *  테두리는 1로, 내부는 2로 만들기 : 
         *  2중 for문으로 y1 ~ y2, x1 ~ x2를 돌면서 2로 채운다. 
         *  단, x가 x1, x2이거나 y가 y1, y2라면 1로 그려준다.
         *  테두리를 그리다가, 2인 내부를 만난다면 1로 만들지 않고 넘어간다.
         */
        for(int[] xy : rectangle) {
        	int x1 = xy[0] * 2, y1 = xy[1] * 2, x2 = xy[2] * 2, y2 = xy[3] * 2;
        	for(int r = y1; r <= y2; r++) {
        		for (int c = x1; c <= x2; c++) {
					if((r==y1 || r==y2 || c==x1 || c==x2) && map[r][c] != 2) map[r][c] = 1;
					else map[r][c] = 2;
				}
        	}
        }
        
		// for (int i = 0; i < 101; i++) {
		// 	for (int j = 0; j < 101; j++) {
		// 		System.out.print(map[i][j]);
		// 	}
		// 	System.out.println();
		// }
        
        int r = characterY*2; 
        int c = characterX*2; 
        er = itemY*2; 
        ec = itemX*2;
        dfs(r, c, 0);
        
        return ans/2;
    }

	private static void dfs(int r, int c, int cnt) {
		if (r == er && c == ec) {
			ans = Math.min(ans, cnt);
			return;
		}
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr<0||nc<0||nr>100||nc>100) continue;
			if (map[nr][nc] != 1) continue;
			map[nr][nc] = 2;
			dfs(nr, nc, cnt+1);
			map[nr][nc] = 1;
		}
	}
}