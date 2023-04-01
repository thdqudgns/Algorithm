/*
    바구니는 스택을 이용하여, 같은 수가 들어오려고 하면 스택에 저장된 수를 pop하자
    board의 맨 위에 있는 값만 사용하므로, board의 열 각각을 스택으로 바꿔서 풀면 더 직관적일 것 같다.
*/
import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int cnt = 0;
        int N = board.length; // board 한 변의 길이 == board를 옮겨담을 스택의 개수
        Stack<Integer>[] dolls = new Stack[N+1]; // moves의 수를 그대로 index로 사용하기 위해 +1함
        for(int i = 1; i <= N; i++) { // board를 옮겨담자
            dolls[i] = new Stack<>(); // 스택 배열에 스택 생성
            for(int row = N-1; row >= 0; row--) { // i-1 열 저장 (dolls는 1부터, board는 0부터 시작이므로)
                // 열 고정, 행 변화
                // board는 아래에서 쌓여 있으므로, 0이 나오면 멈춘다.
                if (board[row][i-1] == 0) break;
                dolls[i].push(board[row][i-1]);
            }
        }
        
        Stack<Integer> baguni = new Stack<>();
        
        for(int m : moves) {
            if (dolls[m].isEmpty()) continue; // 인형이 없다면 pass
            int pick = dolls[m].pop();
            
            if (baguni.isEmpty()) { // 바구니가 비어있다면 push
                baguni.push(pick);
            } else if (pick != baguni.peek()) { // 수가 다르다면 push
                baguni.push(pick);
            } else { // 수가 같다면 pop하고 ++
                baguni.pop();
                cnt++;
            }
        }
        
        return cnt*2; // pop한 인형의 2배
    }
}