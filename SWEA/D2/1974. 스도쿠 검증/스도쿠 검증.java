import java.util.*;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        //System.setIn(new FileInputStream("res/input.txt"));
 
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            // 스도쿠 배열 생성
            int[][] sdocu = new int[9][9];
            for (int x = 0; x<9; x++){
                for (int y = 0; y<9; y++){
                    sdocu[x][y] = sc.nextInt();
                }
            }
             
            // 값 정상 삽입 확인. -> 주석처리 필요
            //for (int x = 0; x < 10; x++) {
            //  System.out.println(Arrays.toString(sdocu[x]));
            //}
             
            // 정답 falg 생성
            int flag = 1;
             
            // 1. 가로 세로 확인
            for (int x = 0; x<9; x++){
                int[] standardW = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                int[] standardH = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                for (int y = 0; y<9; y++){
                    if (standardW[sdocu[x][y]] == 0) standardW[sdocu[x][y]] = 1;
                    if (standardH[sdocu[y][x]] == 0) standardH[sdocu[y][x]] = 1;
                }
                int sumW = Arrays.stream(standardW).sum();
                int sumH = Arrays.stream(standardH).sum();
                if (sumW < 9 || sumH < 9) {
                    flag = 0;
                    break;
                }
            }
             
            //2. 3x3판 확인
            if (flag == 1) {
                int[][] position = {{0,0}, {0,3}, {0,6}, {3,0}, {3,3}, {3,6}, {6,0}, {6,3}, {6,6}}; //0~8
                 
                for (int k=0; k<=8; k++) {   //0~8
                    int[] standard = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};    //0~9
                    int a = position[k][0];
                    int b = position[k][1];
                     
                    for (int i = a; i < a+3; i++) {
                        for (int j = b; j < b+3; j++) {
                            if (standard[ sdocu[i][j] ] == 0) standard[ sdocu[i][j] ] = 1;
                        }
                    }
                     
                    int sumA = Arrays.stream(standard).sum();
                    if (sumA < 9) {
                        flag = 0;
                        break;
                    }
                     
                }// for (int k = 0; k < 9; k++)
            }// if (flag == 1)
 
            System.out.printf("#%d %d \n", test_case, flag);
             
             
        } //test_case
    }// main method
}// class