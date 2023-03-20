class Solution {
    public String solution(int n) {
        String answer = "";
        String[] arr = {"1", "2", "4"};
        while(n > 0) {
            answer = arr[(n - 1) % 3] + answer;
            n = (n - 1) / 3;
        }
        return answer;
    }
}