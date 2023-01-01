import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws IOException
	{
        //이게 반복문 안에 들어가니 문제가 생겼다.
        //stack overflow가 발생함..ㄷㄷ
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		for(int T = 0; T < 10; T++) {
            int t = Integer.parseInt(br.readLine());
			
            int[][] arr = new int[100][100];
            
            for(int i = 0; i<100; i++) {
            	StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j<100; j++) {
                	arr[i][j] = Integer.parseInt(st.nextToken());
                }
			}
            
            int max = 0;
            
            for (int i = 0; i<100; i++) {
            	int sumA = 0;
                int sumB = 0;
                int sumC = 0;
                sumC += arr[i][i];
                for (int j = 0; j<100; j++) {
                	sumA += arr[i][j];
                    sumB += arr[j][i];
                }
                if (sumA > max) max = sumA;
                if (sumB > max) max = sumB;
                if (sumC > max) max = sumC;
            }
            
            
            System.out.printf("#%d %d\n", t, max);
			
		}// test_case
        
	}//main
    
}//Solution