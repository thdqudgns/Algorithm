import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            String[][] a = new String[n][n];
             
            for (int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j=0; j<n; j++) {
                    a[i][j] = st.nextToken();
                }
            }
             
            System.out.println("#"+test_case);
             
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    System.out.print(a[n-j-1][i]);
                }
                System.out.print(" ");
                for (int j=0; j<n; j++) {
                    System.out.print(a[n-i-1][n-j-1]);
                }
                System.out.print(" ");
                for (int j=0; j<n; j++) {
                    System.out.print(a[j][n-i-1]);
                }
                System.out.println();
            }
        }//for test_case
    }//main
}//class