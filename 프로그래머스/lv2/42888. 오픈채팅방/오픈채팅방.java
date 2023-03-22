import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        List<String> tmp = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        int idx = 0;
        for (String s : record) {
            String[] output = s.split(" ");
            
            if (output.length > 2) {
                map.put(output[1], output[2]);    
            }
            
            if("Enter".equals(output[0])) {
                tmp.add(output[1] + "님이 들어왔습니다.");
            } else if ("Leave".equals(output[0])) {
                tmp.add(output[1] + "님이 나갔습니다.");
            }
        }
        
        idx = 0;
        String[] answer = new String[tmp.size()];
        for (String s : tmp) {
            if (s == null) break;
            String[] change = s.split("님");
            answer[idx++] = map.get(change[0]) + "님" + change[1];
        }
        return answer;
    }
}