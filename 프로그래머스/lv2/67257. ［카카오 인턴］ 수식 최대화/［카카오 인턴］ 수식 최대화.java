/**
    연산문자는 3개만 주어진다. -> 우선순위를 정하는 경우의 수는 단 6가지
    완전탐색으로 해결하면 된다.
    1. 어떤 연산자가 있는지 확인하기
    2. 해당 연산자들의 우선순위를 매기기
    3. 계산하고, 절댓값 구하기
    4. 최댓값 반환
 */
import java.util.*;
import java.lang.*;

class Solution {
    static int N;
    static String[] priority;
    static boolean[] used;
    static long answer;
    
    static List<String> opt;
    static List<String> optIdx;
    static List<Long> input;
    
    static List<Long> copyInput;
    static List<String> copyOptIdx;
    
    public long solution(String exp) {
        String[] tmpInput = exp.split("\\+|-|\\*");
        input = new ArrayList<>();
        for (String s : tmpInput) {
            input.add(Long.parseLong(s));
        }
        
        //System.out.print("input : " + input);
        
        optIdx = new ArrayList<>();
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '+') optIdx.add("+");
            if (exp.charAt(i) == '-') optIdx.add("-");
            if (exp.charAt(i) == '*') optIdx.add("*");   
        }
        //System.out.println(", optIdx : " + optIdx);
        opt = new ArrayList<>();
        if (exp.contains("+")) opt.add("+");
        if (exp.contains("-")) opt.add("-");
        if (exp.contains("*")) opt.add("*");
        
        N = opt.size();
        
        priority = new String[N];
        used = new boolean[N];
        
        perm(0);
        
        //System.out.print(opt);
        
        return answer;
    }
    
    static void perm(int cnt) {
        if (cnt == N) {
            //System.out.println(Arrays.toString(priority));
            copyInput = new ArrayList<>(input);
            copyOptIdx = new ArrayList<>(optIdx);
            calculation(priority);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (used[i]) continue;
            used[i] = true;
            priority[cnt] = opt.get(i);
            perm(cnt+1);
            used[i] = false;
        }
    }
    
    static void calculation(String[] priority) {
        for(String s : priority) {
            while (copyOptIdx.contains(s)) {
                int idx = copyOptIdx.indexOf(s);
                calByOpt(idx, s);
                //System.out.print("input : " + copyInput);
                //System.out.println(", optIdx : " + copyOptIdx);
            }
        }
        answer = Math.max(answer, Math.abs(copyInput.get(0)));
    }
    
    static void calByOpt(int idx, String opt) {
        long tmp = 0L;
        long a = copyInput.get(idx);
        long b = copyInput.get(idx+1);
        
        if (opt.equals("+")) tmp = a + b;
        else if (opt.equals("-")) tmp = a - b;
        else tmp = a * b;
        
        copyOptIdx.remove(idx);
        copyInput.remove(idx+1);
        copyInput.set(idx, tmp);
    }
}