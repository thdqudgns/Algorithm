/*
    (r, 0) -> 무조건 L, 그리고 좌측 엄지손가락의 위치를 해당 자리로 옮긴다.
    (r, 2) -> 무조건 R, 그리고 우측 엄지손가락의 위치를 해당 자리로 옮긴다.
    (r, 1) -> abs(x1 - x2) + abs(y1 - y2) 로 왼손 오른손의 위치를 각각 계산하여
              더 가까운 손이 움직인다. 만일 거리가 같다면 hand에 따라 정한다.
*/
import java.util.*;
import static java.lang.Math.*;
class Solution {
    
    static Map<Character, int[]> pad; // 숫자를 key로, 위치를 value로
    static int[][] thumbsPosition; // 엄지와 검지의 위치 저장할 배열
    static StringBuffer answer = new StringBuffer(); // 정답 반환
    static int[] LThumbs = {3, 0};
    static int[] RThumbs = {3, 2};
    
    static void makePad() {
        pad = new HashMap<>();
        char num = '0';
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                num = (char)(num + 1);
                pad.put(num, new int[]{r, c});
            }
        }
        pad.put('*', new int[]{3, 0});
        pad.put('0', new int[]{3, 1});
        pad.put('#', new int[]{3, 2});
        
        thumbsPosition = new int[4][3];
    }
    
    static int getLength(int[] a, int[] b) {
        return abs(a[0] - b[0]) + abs(a[1] - b[1]);
    }
    
    public String solution(int[] numbers, String hand) {
        makePad();
        if (hand.equals("right")) hand = "R";
        else hand = "L";
        
        for(int n : numbers) {
            char num = (char)('0' + n);
            int[] get = pad.get(num); // 패드번호의 좌표

            if (get[1] == 0) {
                answer.append("L");
                LThumbs = get; // 사용한 손의 좌표 옮기기
            } else if (get[1] == 2) {
                answer.append("R");
                RThumbs = get; // 사용한 손의 좌표 옮기기
            } else {
                int lenL = getLength(get, LThumbs);
                int lenR = getLength(get, RThumbs);
                if (lenL == lenR) { // 거리가 같으면 손잡이대로
                    answer.append(hand);
                    if (hand.equals("L")) 
                        LThumbs = get; // 사용한 손의 좌표 옮기기
                    else 
                        RThumbs = get; // 사용한 손의 좌표 옮기기
                } else if (lenL < lenR) { // 거리가 더 짧은 손 사용
                    answer.append("L");
                    LThumbs = get; // 사용한 손의 좌표 옮기기
                } else {
                    answer.append("R");
                    RThumbs = get; // 사용한 손의 좌표 옮기기
                }
            }
        }
        return answer.toString();
    }
}