/*
    이모티콘 플러스 서비스 가입자를 최대한 늘리는 것.
    이모티콘 판매액을 최대한 늘리는 것.
    
    n명의 카카오톡 사용자들에게 이모티콘 m개를 할인하여 판매합니다.
    이모티콘마다 할인율은 다를 수 있으며, 할인율은 10%, 20%, 30%, 40% 중 하나로 설정됩니다.
     
    각 사용자들은 자신의 기준에 따라 "일정 비율 이상 할인하는 이모티콘을 모두" 구매합니다.
    각 사용자들은 자신의 기준에 따라 이모티콘 구매 비용의 합이 "일정 가격 이상이 된다면", 
    이모티콘 구매를 모두 취소하고 이모티콘 플러스 서비스에 "가입"합니다.
    
    서비스 가입 수와 이모티콘 매출액 return
    
    users의 원소는 [비율, 가격]의 형태입니다.
    emoticons[i]는 i+1번 이모티콘의 정가를 의미합니다.
*/
import java.util.*;
class Solution {
    
    static int[] sale;
    static int[] answer;
    static int U, E;
    static int[][] user;
    static int[] emoticon;
    
    public int[] solution(int[][] users, int[] emoticons) {
        /* 
            중복순열문제. 이모티콘 각각의 할인율을 [10, 10, 10, 20, 10, 10, 30] 이런식으로 완탐해서, 
            각각의 인형들의 할인율이 정해졌을 때, users배열을 users.length만큼 돌면서 각각 구매를 하는지 안하는지 금액을 누적합하고
            서비스를 가입하는지 안하는지 판단한다.
        
            선형탐색을 하면서 할인 기준(users[i][0]) 이상이 된다면 임시가격계산변수에 누적한다.
            누적된 금액이 일정 가격(users[i][1]) 이상이 된다면, 구매하지 않고 tmpAns[0]++ 된다.
            누적된 금액이 일정 가격 미만이라면 다 구매하고, 구매한 임시가격계산변수의 값을 tmpAns[1]에 누적한다.
            tmpAns[0] 이 answer[0] 이상이고, tmpAns[1]이 answer[1] 초과라면, answer를 갱신한다.
         */
        answer = new int[2];
        
        U = users.length;
        E = emoticons.length;
        sale = new int[E];
        
        user = new int[U][2];
        for(int i = 0; i < U; i++) {
            for(int j = 0; j < 2; j++) {
                user[i][j] = users[i][j];
            }
        }
        
        emoticon = new int[E];
        for(int i = 0; i < E; i++) {
            emoticon[i] = emoticons[i];
        }
        
        perm(0);
        
        return answer;
    }
    
    static void perm(int cnt) {
        if (cnt == E) {
            //System.out.println(Arrays.toString(sale));
            cal(sale);
            return;
        }
        int ten = 10;
        for(int i = 0; i < 4; i++){
            if (sale[cnt] != 0) continue;
            
            sale[cnt] = ten;
            perm(cnt + 1);
            sale[cnt] = 0;
            ten += 10;
        }
    }
    
    static void cal(int[] sale) {
        int service = 0;
        int sumPrice = 0;
        for(int i = 0; i < U; i++) {
            int rate = user[i][0];
            int priceLimit = user[i][1];
            int price = 0;
            for(int j = 0; j < E; j++) {
                if(sale[j] < rate) continue;
                // 가격 = 원가 * (1 - 할인비율/100.0)
                price += emoticon[j] * (1 - sale[j]/100.0);
            }
            if (price >= priceLimit) { // 서비스 가입 조건
                service++;
            } else { // 서비스에 가입 안함 == 이모티콘 삼
                sumPrice += price;
            }
        }
        int[] tmpAns = {service, sumPrice};
        // tmpAns[0] 이 answer[0] 이상이고, tmpAns[1]이 answer[1] 초과라면, answer를 갱신한다.
        if (tmpAns[0] > answer[0]){
            answer = tmpAns;
        } else if (tmpAns[0] == answer[0] && tmpAns[1] > answer[1]) {
            answer = tmpAns;
        }
    }
}