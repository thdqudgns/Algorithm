import java.util.*;
/**
    가장 작은 두 개를 계속 사용하는 문제다.
    시간복잡도 = (가장 작은 두 수를 찾기 위해 정렬하는 시간) * (배열의 개수 * 2) // 2는 두 수를 골라 연산하는 것
    
    1. 배열을 계속 정렬할까? -> 시간초과 날 것 같다. 
    두 개를 더하는 시간 최대 백만, 백만번 각각 정렬하는 시간 백만log(백만)
    (백만 * 백만lon백만) + (2 * 백만)= O(백만^2log백만) => 일조 * 19 = 19조... 말도안된다.
    
    2. 최소힙을 사용하면 100만을 정렬하는데 log₂백만 ≒ 20으로, 1900만 보다 굉장히 빠르다.
    시간복잡도 = 20 * 100만 * 2 = 4000만
    
    무려 사십칠만오천배 빨라졌다.
 */

class Solution {
    public int solution(int[] scoville, int K) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        
        // 배열 -> 우선순위큐 (최악 100만)
        for (int i : scoville) {
            pq.offer(i);
        }
        
        // (100만 * 20 * 2)
        while (pq.peek() < K && pq.size() >= 2) {
            int a = pq.poll();
            int b = pq.poll();
            int tmp = a + b * 2; // (2) - poll하고, 더하는 연산횟수를 대략 2로 
            pq.offer(tmp); // (20) - 가장 작은값을 연산하는 것이므로 앞부분에서 정렬이 될 것이기에, 실제 20번까지는 아니다.
            answer++;
        }
        
        // pq에 값이 하나 남았는데, K보다 작다면 K 이상으로 만들 수 없는 경우다.
        if (pq.peek() < K) answer = -1;
        return answer;
    }
}
