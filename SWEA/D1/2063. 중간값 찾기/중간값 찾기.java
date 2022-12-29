import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
         
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int index = N/2;
        //sc.nextLine();
         
        ArrayList<Integer> a = new ArrayList();
         
        for (int i = N; N>0; N--) {
            int tmp = sc.nextInt();
            a.add(tmp);
        }
         
        Collections.sort(a);
         
        // N/2 로 하면 안나오고, index에 N/2를 저장하고 출력해야만 제대로 출력된다.
        // int 데이터 타입으로 확실하게 정해줘야 하나보다.
        System.out.println(a.get(index));
         
    }
}