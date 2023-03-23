/**
    압축하려면 어차피 하나씩 다 확인해봐야 한다. 
    압축하는 중에 현재 저장된 최솟값보다 길이가 길어진다면 return하여 백트래킹
*/
class Solution {
    static int answer, count;
    static StringBuilder result;
    public int solution(String s) {
        answer = s.length();
        for(int i = 1; i <= s.length()/2; i++) {
            solve(s, i); // i를 기준으로 문자열을 잘라서 압축해본다.
        }
        return answer;
    }
    
    static void solve(String s, int num) {
        result = new StringBuilder();
        String base = s.substring(0, num);
        count = 1;
        for(int i = num; i<=s.length(); i += num) {
            int endIdx = Math.min(i + num, s.length());
            String compare = s.substring(i, endIdx);
            if(base.equals(compare)) {
                count++;
            } else {
                if (count >= 2) result.append(count);
                result.append(base);
                base = compare;
                count = 1;
            }
            if (result.length() > answer) return;
        }
        result.append(base);
        answer = Math.min(answer, result.length());
    }
}