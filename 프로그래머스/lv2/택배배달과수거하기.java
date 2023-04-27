/*  
    =>  택배를 주거나 회수하면서 왕복하는 최소 이동거리를 구해라
        단, 트럭에 담을 수 있는 택배의 제한이 있다.
        
        가능한 최대로 배송하고, 가능한 최대로 받아온다.      
        ==================================
    input의 해결과정을 보면, 뒤에서부터 배송한다.
    n이 10만이기에 nlogn이나 n으로 풀어야 한다.
    
    무조건 최대로 멀리나가는 만큼 왕복운동이므로
    최대로 멀리나가는 것을 점차 줄여야 한다.
    
    누적합이거나 최대힙이겠다. 최대힙이 나을듯 (index 기준 내림차순 정렬)
*/
import java.util.*;

class Box implements Comparable<Box>{
    int index, deli, pick;
    public Box(int index, int deli, int pick) {
        this.index = index;
        this.deli = deli;
        this.pick = pick;
    }
    public int compareTo(Box o) {
        return o.index - this.index;
    }
    public String toString() {
        return "index : " + index + ", deli : " + deli + ", pick : " + pick;
    }
}

class Solution {
    
    static PriorityQueue<Box> pq = new PriorityQueue<>();
    static int allDeli, allPick, C, N, ans;
    static int maxLen = 0;
    
    public long solution(int cap, int n, int[] delis, int[] picks) {
        for(int i=0; i<n; i++) {
            pq.offer(new Box(i, delis[i], picks[i]));
            allDeli += delis[i]; // 택배를 가져나갈 때 얼마나 필요한지 세주자.
            allPick += picks[i];
        }
        /*
        for(int i=0; i<n; i++) {
            System.out.println(pq.poll());
        }
        */
        C = cap;
        N = n;
        solve();
        return ans;
    }
    
    static void solve() {
        if (pq.isEmpty()) return;
        if (allDeli == 0 && allPick == 0) return;
        
        maxLen = 0;
        start();
        rollback();
        ans += maxLen*2;
        if (pq.isEmpty()) return;
        solve();
    }
    
    static void start() {
        
        if (allDeli == 0) return;
        
        // 얼마나 챙겨나갈지 정한다.
        int get = 0;
        if (allDeli >= C) {
            get = C;
        } else {
            get = allDeli;
        }
        
        allDeli -= get;
        
        // 택배 배송
        Queue<Box> tmpQ = new ArrayDeque<>();
        while (get > 0 && !pq.isEmpty()) {
            Box b = pq.poll();
            
            if (b.deli == 0 && b.pick != 0) {
                tmpQ.offer(b);
                continue;
            } else if (b.deli == 0 && b.pick == 0) {
                continue;
            }
            
            if (b.index > maxLen) maxLen = b.index + 1;
            
            if (b.deli >= get) {
                b.deli -= get;
                get = 0;
            } else {
                get -= b.deli;
                b.deli = 0;
            }
            
            if (b.deli > 0 || b.pick > 0) {
                pq.offer(b);    
            }
        }
        
        while(!tmpQ.isEmpty()) pq.offer(tmpQ.poll());
    }
    
    static void rollback () {
        if (allPick == 0) return;
        
        // 택배 수거
        int back = 0;
        if (allPick >= C) {
            back = C;
        } else {
            back = allPick;
        }
        
        allPick -= back;
        
        Queue<Box> tmpQ = new ArrayDeque<>();
        while (back > 0 && !pq.isEmpty()) {
            Box b = pq.poll();
            
            if (b.pick == 0 && b.deli != 0) {
                tmpQ.offer(b);
                continue;
            } else if (b.pick == 0 && b.deli == 0) {
                continue;
            }
            
            if (b.index > maxLen) maxLen = b.index + 1;
            
            // 현재 집에서 가져와야 하는 택배가 back보다 크거나 같을 때
            if (b.pick >= back) {
                b.pick -= back;
                back = 0;
            } else { // back보다 작을 때
                back -= b.pick;
                b.pick = 0;
            }
            
            if (b.deli > 0 || b.pick > 0) {
                pq.offer(b);    
            }
        }
        while(!tmpQ.isEmpty()) pq.offer(tmpQ.poll());
    }
}

