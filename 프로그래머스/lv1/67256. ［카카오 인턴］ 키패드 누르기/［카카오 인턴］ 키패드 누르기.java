/*
    (r, 0) -> 무조건 L, 그리고 좌측 엄지손가락의 위치를 해당 자리로 옮긴다.
    (r, 2) -> 무조건 R, 그리고 우측 엄지손가락의 위치를 해당 자리로 옮긴다.
    (r, 1) -> abs(x1 - x2) + abs(y1 - y2) 로 왼손 오른손의 위치를 각각 계산하여
              더 가까운 손이 움직인다. 만일 거리가 같다면 hand에 따라 정한다.
*/
import java.util.*;
class Solution {
    
    static Map<Character, int[]> pad; // 숫자를 key로, 위치를 value로
    static int[][] thumbsPosition; // 엄지와 검지의 위치 저장할 배열
    static StringBuffer answer = new StringBuffer(); // 정답 반환
    static int[] LThumbs = {3, 0};
    static int[] RThumbs = {3, 2};
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    
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
        //for(int[] out : pad.values()) System.out.print(Arrays.toString(out) + " ");
        
        thumbsPosition = new int[4][3];
        
    }
    
    public String solution(int[] numbers, String hand) {
        makePad();
        if (hand.equals("right")) hand = "R";
        else hand = "L";
        
        for(int n : numbers) {
            char num = (char)('0' + n);
            int[] get = pad.get(num); // 패드번호의 좌표
            System.out.print(Arrays.toString(get) + " ");
            if (get[1] == 0) {
                answer.append("L");
                LThumbs = get; // 왼쪽엄지 좌표 <- 패드번호 좌표
            } else if (get[1] == 2) {
                answer.append("R");
                RThumbs = get; // 오른쪽엄지 좌표 <- 패드번호 좌표
            } else {
                int lenL = Math.abs(get[0] - LThumbs[0]) + Math.abs(get[1] - LThumbs[1]);
                int lenR = Math.abs(get[0] - RThumbs[0]) + Math.abs(get[1] - RThumbs[1]);
                if (lenL == lenR) { // 거리가 같으면 손잡이대로
                    answer.append(hand);
                    if (hand.equals("L")) LThumbs = get;
                    else RThumbs = get;
                } else if (lenL < lenR) {
                    answer.append("L");
                    LThumbs = get;
                } else {
                    answer.append("R");
                    RThumbs = get;
                }
            }
        }
        return answer.toString();
    }
}