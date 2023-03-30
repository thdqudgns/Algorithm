import java.util.*;

class Solution {
    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> tmpAdd = new ArrayList<>();
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < speeds.length; i++) {
            q.offer(new int[]{progresses[i], speeds[i]});
        }
        
        while(!q.isEmpty()) {
            for(int i = 0; i < q.size(); i++) {
                int[] get = q.poll();
                q.offer(new int[]{get[0] + get[1], get[1]});
            }
            int cnt = 0;
            //System.out.println(q.peek()[0]);
            while(!q.isEmpty() && q.peek()[0] >= 100) { // while문이기 때문에 비어있지 않음을 체크하여 NullPointerException가 발생하지 않게 한다.
                cnt++;
                q.poll();
            }
            if(cnt > 0) tmpAdd.add(cnt);
        }
        
        int[] answer = new int[tmpAdd.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = tmpAdd.get(i);
        }
        
        return answer;
    }
}