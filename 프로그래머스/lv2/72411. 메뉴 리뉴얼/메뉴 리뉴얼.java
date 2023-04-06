import java.util.*;
class Solution {
    static char[] combStr;
    static Map<String, Integer> map = new HashMap<>(); // 문자열의 개수;
    
    public String[] solution(String[] orders, int[] course) {
        int N = orders.length;
        for(String s : orders) { // s에 대하여 조합할 수 있는
            char[] tmp = s.toCharArray();
        	Arrays.sort(tmp);
        	s = String.valueOf(tmp);
            for(int n : course) { // 길이 n인 문자열을 만들자
                if (s.length() < n) break;
                else if (s.length() == n) { // 없으면 새로 넣고, 있으면 수를 +1
                    map.put(s, map.getOrDefault(s, 0) + 1);
                } else {
                    combStr = new char[n];
                    comb(0, 0, n, s);
                }
            }
        }
        List<String> answerTmp = new ArrayList<>();
        Set<String> set = map.keySet();
        // 동일한 길이의 메뉴 구성 중, 개수가 가장 많은 것만 answerTmp에 넣는다.
        for (int n : course) { // 길이가 n인 것에 대해서, 길이가 가장 긴 것을 찾아보자
        	int max = 0;
        	for(String key : set) {
        		if (key.length() != n) continue;
        		if (map.get(key) <= max) continue;
        		max = map.get(key);
        	}
        	for(String key : set) {
        		if (key.length() != n) continue;
                if (max == 1) continue;
        		if (map.get(key) == max) {
        			answerTmp.add(key);
        		}
        	}
        }
        
        String[] answer = new String[answerTmp.size()];
        for (int i = 0; i < answer.length; i++) {
			answer[i] = answerTmp.get(i);
		}
        Arrays.sort(answer);
        return answer;
    }
    
    static void comb(int cnt, int start, int n, String s) {
        if (cnt == n) {
        	String key = String.valueOf(combStr);
            map.put(key, map.getOrDefault(key, 0) + 1);
            return;
        }
        for(int i = start; i < s.length(); i++) {
            combStr[cnt] = s.charAt(i);
            comb(cnt+1, i+1, n, s);
        }
    }
}