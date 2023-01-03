import java.util.*;
import java.io.*;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
       
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        
        for(int test_case = 1; test_case <= T; test_case++)
        {
         
            int n, m;
            n = sc.nextInt();
            m = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            for (int i = 0; i<n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i=0; i<m; i++) {
                b[i] = sc.nextInt();
            }
             
            int big;
            big = (n >= m) ? n : m;
            int[] A = new int[big];
            int[] B = new int[big];
            int x, y;
             
            if (m > n) {
                x = m;
                y = n;
                A = b.clone();
                B = a.clone();
            } else {
                x = n;
                y = m;
                A = a.clone();
                B = b.clone();
            }
             
            // x: 둘 중 긴 배열의 길이, A: 둘 중 긴 배열의 배열, y: 짧은 배열의 길이, B: 짧은 배열
            // 이제 곱하고 더하면 된다.
            int result = -2100000000;
            for (int i=0; i<=x-y; i++) {
                int tmp = 0;
                for (int s=i; s<i+y; s++) {
                    tmp += A[s]*B[s-i];
                }
                if (tmp > result) result = tmp;
            }
             
            System.out.printf("#%d %d\n", test_case, result);
 
        }
    }
}