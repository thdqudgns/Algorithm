/**
    1. 기울기로 규칙을 찾아내는 건가? 가로세로가 1억이면 숫자가 너무 크니까 수식 계산으로 푸는 것 같은데.
    기울기 = h/w, 기울기가 정수가 될 때까지 곱한다. 
    정수가 되었을 때 곱한 횟수가 x, x * 기울기 = y가 되는데, (x, y)가 반복되는 규칙의 기준이 된다. 
    -> 마땅한 풀이가 떠오르지 않아서 기각
    
    2. 잠시 자면서 생각해봤다. 기울기(lean = h/w)를 구하고, 한 칸씩 이동한다.
    이동하는 규칙은 (0,0)부터 (x, y)까지의 기울기(tmpLean = y/x)를 매번 구하면서, lean > tmpLean이라면 위로, lean < tmpLean 이라면 우측으로 이동한다.
    만일 lean == tmpLean이 되는 순간이 온다면 그 (x,y)가 기준이 되는 것이므로, 
    진행을 멈추고 (그 순간까지 지나온 종이의 개수) * (전체가로길이w / 지나온가로길이x) 으로
    지나게 될 모든 종이의 개수를 구한다. 마지막에는 (전체 종이 개수) - (구한 종이 개수)
*/
class Solution {
    public long solution(double w, double h) {
        long answer = 1;
        double lean = h / w;
        double x = 1, y = 1;
        double tmpLean = y / x;
        int cnt = 1;
        while(lean != tmpLean) {
            if (lean > tmpLean) {
                cnt++;
                tmpLean = ++y / x; // 위로
                continue;
            } else if (lean < tmpLean) {
                cnt++;
                tmpLean = y / ++x; // 우측으로
                continue;
            }
        }
        int total = cnt * (int)(w / x);
        answer = ((long)(w * h)) - total;
        return answer;
    }
}
