import java.util.*;
import java.io.*;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int t = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());    // 여기서 점수를 받고,
             
            //점수배열 생성
            int[] score = new int[1000];
            for (int i = 0; i < 1000; i++) {
                score[i] = Integer.parseInt(st.nextToken());    // 배열에는 나눠서 저장한다
            }
             
            // 점수 세는 배열 만들기
            int[] scoreCnt = new int[101];
             
            //저장된 점수들을 인덱스별로 카운트하기
            for(int i = 0; i<1000; i++) {
                scoreCnt[score[i]]++;
            }
            //현재 scoreCnt에는 점수(index)의 개수가 저장되어 있다.
             
            // 배열을 뒤집어주자
            /*
            int[] reverseScore = new int[101];
            for (int i = 0; i<101; i++) {
                reverseScore[i] = scoreCnt[100-i];
            }
            */
             
            // 최대값을 저장하자 - 개수가(배열에 저장된 값이) 저장된 최대개수 이상이면 해당 index를 result에 저장하면 됨  
            int cntMax = 0;
            int result = 0;
            for (int i = 0; i<101; i++) {
                if (scoreCnt[i] >= cntMax) {
                    cntMax = scoreCnt[i];
                    result = i;
                }
            }
             
            System.out.printf("#%d %d\n",t, result);
         
 
        }
    }
}