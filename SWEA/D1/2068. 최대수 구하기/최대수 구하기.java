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
             
            ArrayList<Integer> a = new ArrayList();
            
            for (int tmp = 10; tmp>0; tmp--) {
                a.add(sc.nextInt());
            }
             
            Collections.sort(a);
         
            //System.out.print('#');
            //System.out.print(test_case);
            //System.out.print(" ");
            //System.out.println(a.get(a.size() - 1));
             
            System.out.printf("#%d %d\n",test_case, a.get(a.size() - 1));
 
        }
    }
}