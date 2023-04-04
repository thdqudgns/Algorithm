class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] numbers = new int[46];
        
        for (int num : lottos) numbers[num]++; // 0~45
        
        int cnt = 0; // 일치하는 개수
        for (int num : win_nums) if(numbers[num] == 1) cnt++; // 1~45
        
        int[] rank = {6, 6, 5, 4, 3, 2, 1}; // 순위배열;
        return new int[]{rank[cnt + numbers[0]], rank[cnt]};
    }
}