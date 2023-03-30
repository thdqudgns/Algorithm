import java.util.*;

class Solution {
    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> tmpAdd = new ArrayList<>(); // 정답을 임시 저장할 List
        Queue<int[]> q = new ArrayDeque<>(); // progresses와 speeds를 함께 저장할 Queue <- 순회하면서 넣고 뺄 예정이라 Queue로 구현함
        
        // 큐에 값 삽입
        for(int i = 0; i < speeds.length; i++) {
            q.offer(new int[]{progresses[i], speeds[i]});
        }
         
        while(!q.isEmpty()) {
            // 큐를 순회하면서 speed를 더한 값을 새로 저장한다. 
            for(int i = 0; i < q.size(); i++) {
                int[] get = q.poll();
                q.offer(new int[]{get[0] + get[1], get[1]});
            }
            
            int cnt = 0; // 배포할 수 있는 기능 카운트
            // 큐가 비어있지 않고, 100을 넘는다면 cnt를 늘리고, 큐에서 제외시킨다.
            // 100을 넘지 않는다면 break되므로 문제의 조건에 합당하다.
            while(!q.isEmpty() && q.peek()[0] >= 100) { // while문이기 때문에 비어있지 않음을 체크하여 NullPointerException가 발생하지 않게 한다.
                cnt++;
                q.poll();
            }
            // cnt가 세어졌다면 tmpAdd에 추가
            if(cnt > 0) tmpAdd.add(cnt);
        }
        // tmpAdd의 size만큼만 정답 배열을 만들고 값 삽입
        int[] answer = new int[tmpAdd.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = tmpAdd.get(i);
        }
        // 끝
        return answer;
    }
}