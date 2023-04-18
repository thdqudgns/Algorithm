/*
    먼저, n이 1~10, info의 길이가 11이라면 완전탐색을 해도 되지 않을까?
    1
    10
    10 + 10*9
    10 + 10*9 + 10*9*8
    10 + 10*9 + 10*9*8 + 10*9*8*7
    10 + 10*9 + 10*9*8 + 10*9*8*7 + 10*9*8*7*6 ...
    하면 9864101
*/
import java.util.*;
class Solution {
	
	public static void main(String[] args) {
		solution(5, new int[]{2,1,1,1,0,0,0,0,0,0,0});
		System.out.println(Arrays.toString(ans));
	}
	
    static int[] ans, apeach;
    static int cha = 0;
    public static int[] solution(int n, int[] info) {
        ans = new int[11]; // answer
        apeach = new int[11]; // apeach 
        for(int i = 0; i < 11; i++) apeach[i] = info[i];
        makeArr(new int[11], n, 10);
        int sum = 0;
        for(int i = 0; i < 11; i++) sum += ans[i];
        if (sum == 0) return new int[]{-1};
        return ans;
    }
    
    public static void makeArr(int[] lion, int n, int idx) { // 사용 가능한 화살 개수 n
        if (n == 0) { // lion 조합 이후 비교
            int l = 0, a = 0;
            for(int i = 0; i < 11; i++) {
            	if(lion[i] == 0 && apeach[i] == 0) continue;
                if(lion[i] > apeach[i]) {
                	l += 10 - i;
                } else {
                	a += 10 - i;
                }
            }
            if (l <= a) return; // 점수가 낮거나 같으면 return;
            //System.out.println(l-a);
            //System.out.println(Arrays.toString(lion));
            if (l-a > cha) { // 차가 가장 클 때 찾는다.
            	cha = Math.max(cha, l-a);
                for(int i = 0; i < 11; i++) ans[i] = lion[i];   
            }
            return;
        }
        if (idx < 0) return;
        // lion 조합하기
        int tmpN = n;
        // lion[idx] = 5,4,3,2,1,0;
        while (tmpN >= 0) {
           	lion[idx] = tmpN;
           	makeArr(lion, n-tmpN, idx-1);
        	tmpN--;
        }
    } 
}