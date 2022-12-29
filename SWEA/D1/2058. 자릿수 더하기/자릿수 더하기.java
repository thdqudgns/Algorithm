import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int result = 0;
         
        while (a != 0) {
            int tmp = a % 10;
            result += tmp;
             
            a /= 10;
        }
         
        System.out.println(result);
    }
}