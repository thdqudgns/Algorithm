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
        result = new StringBuilder();   // 문자열을 더해나갈 것이므로 StringBuilder 사용함
        
        // 기준이 되는 문자열 저장
        String base = s.substring(0, num);
        
        // 똑같은 문자열의 반복횟수
        count = 1;
        
        for(int i = num; i <= s.length(); i += num) {
            
            // substring할 끝 index가 s.length()을 넘지 않도록 조정한다.
            int endIdx = Math.min(i + num, s.length());
            
            // 기준 문자열과 비교할 문자열. i ~ endIdx 전까지 자른다.
            String compare = s.substring(i, endIdx);
            
            if(base.equals(compare)) { // 같다면 count +1
                count++;
            } else {    // 같지 않다면 base를 result에 추가해야 한다.
                if (count >= 2) result.append(count); // 반복횟수가 1이 아니라면 (2부터) 반복횟수를 result에 끼워 넣는다.
                result.append(base); // count에 상관없이 base문자열을 result에 붙인다.
                base = compare; // 그리고 기준문자열을 compare로 갱신한다.
                count = 1; // 반복횟수 1로 초기화
            }
            // 저장된 최솟값보다 길이가 길어진다면 return하여 백트래킹
            if (result.length() > answer) return;
        }
        result.append(base); // 마지막에 남은 문자열을 더해준다.
        answer = Math.min(answer, result.length()); // 최솟값 갱신
    }
}