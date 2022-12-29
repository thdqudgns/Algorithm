import java.util.*;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
         
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int result = 0;
            for (int i = 10; i > 0; i--) result += sc.nextInt();
             
            //Math.round를 사용하여 반올림 할 때, 나누는 수가 10이면 반올림이 안되고, 10.0으로 실수형으로 나눠야 반올림이 먹힌다.
            //왜냐하면 result/10은 바로 정수로 나와서, 28.6이 아니라 28로 나오기 때문이다.
            System.out.printf("#%d %d\n", test_case, Math.round(result/10.0));
 
        }
    }
}