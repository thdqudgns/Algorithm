import java.util.*;

class Solution {
    public int solution(int storey) {
        int now = 0;
        int answer = 0;
        while(storey > 0){
            now = storey % 10;
            storey /= 10;
            
            if(now < 5){answer += now;}
            else if(now > 5){answer += (10 - now); storey++; }
            else{
                if(storey % 10 > 4){
                    answer += (10 - now);
                    storey++;
                }
                else {
                    answer += now;
                }                
            }
        }
        return answer;
    }
}