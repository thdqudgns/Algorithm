class Solution {
    public String solution(int n) {
        String answer = "";
        String[] arr = {"1", "2", "4"};
        while(n > 0) {
            int q = (n - 1)/3; // 몫
            int r = (n - 1)%3; // 나머지
            answer = String.valueOf(arr[r]) + answer;
            n = q;
        }
        return answer;
    }
}