import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        // Change의 경우에는 기록이 남지 않는다. 그러므로 결과배열의 길이는 모른다. 
        // 배열의 길이가 어떻게 될지 몰라서 List로 임시 저장 배열 만든다.
        List<String> tmp = new ArrayList<>();
        
        // userid : nickname 을 key-value 쌍으로 저장한다.
        // 이렇게 하면 마지막으로 바뀐 닉네임이 저장된다.
        Map<String, String> map = new HashMap<>();
        
        // 입력받은 record배열을 순회하면서 입퇴장, userid, nickname을 관리한다.
        for (String s : record) {
            // output[0]: 입퇴장, output[1]: userid, output[2]: nickname
            String[] output = s.split(" "); // ""이 아니라, " "로 띄어써야 에러가 나지 않는다.
            
            if (output.length > 2) { // Enter이거나 Change라면
                map.put(output[1], output[2]);  // userid를 key로 하여 nickname을 갱신한다. (Map은 add()와 put()의 동작이 같다.)
            }
            
            // Enter, Leave 각각의 경우에 userid로 tmp에 저장해놓는다. -> 마지막에 userid를 nickname으로 바꿀거다.
            if("Enter".equals(output[0])) {
                tmp.add(output[1] + "님이 들어왔습니다.");
            } else if ("Leave".equals(output[0])) {
                tmp.add(output[1] + "님이 나갔습니다.");
            }
        }
        
        //이제 정답을 반환하기 위해 tmp길이만큼 String[] answer를 생성한다.
        int idx = 0;
        String[] answer = new String[tmp.size()];
        for (String s : tmp) {
            String[] change = s.split("님"); // "님"을 기준으로 userid와 뒷부분을 나눈다.
            answer[idx++] = map.get(change[0]) + "님" + change[1]; // userid를 nickname으로 바꾸어 저장한다.
        }
        return answer;
    }
}