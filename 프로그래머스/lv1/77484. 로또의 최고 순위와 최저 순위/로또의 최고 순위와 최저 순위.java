class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] numbers = new int[46];
        for (int num : lottos) numbers[num]++; // 0~45
        int cnt = 0; // 일치하는 개수
        for (int num : win_nums) if(numbers[num] == 1) cnt++; // 1~45
        
        /*
            0~1개 6순위
            2개 5순위
            3개 4순위
            ...
            6개 1순위
         */
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        int high = cnt + numbers[0];
        int low = cnt;
        int[] answer = {rank[high], rank[low]}; // 순위배열
        return answer;
    }
}