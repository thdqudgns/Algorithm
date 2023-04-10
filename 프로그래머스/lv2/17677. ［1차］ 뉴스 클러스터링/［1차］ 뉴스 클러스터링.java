/**
    정규표현식 : [^~] ~값들을 제외하여 선택
*/
import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        List<String> listA = new ArrayList<>();
        List<String> listB = new ArrayList<>();
        
        for(int i = 0; i < str1.length()-1; i++) {
            String tmpA = str1.substring(i, i+2);
            if(!tmpA.matches("[a-z]+")) continue;
            listA.add(tmpA);
        }
        
        for(int i = 0; i < str2.length()-1; i++) {
            String tmpB = str2.substring(i, i+2);
            if(!tmpB.matches("[a-z]+")) continue;
            listB.add(tmpB);
        }
        
        
        List<String> cross = new ArrayList<>();
        Set<String> setA = new HashSet<>(listA);
        Set<String> setB = new HashSet<>(listB);
        for(String s : setA) {
            if(setB.contains(s)) {
                int cntA = 0, cntB = 0;
                for(String tmp : listA) {
                    if(s.equals(tmp)) cntA++;
                }
                for(String tmp : listB) {
                    if(s.equals(tmp)) cntB++;
                }
                int cnt = cntA < cntB ? cntA : cntB;
                for(int i = 0; i < cnt; i++) cross.add(s);
            }
        }
        
        int all = listA.size() + listB.size() - cross.size();
        if (all == 0 && cross.size() == 0) return 65536;
        int answer = (int)(cross.size() / (double)all * 65536);
        return answer;
    }
}