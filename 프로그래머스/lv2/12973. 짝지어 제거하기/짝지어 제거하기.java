import java.util.*;
class Solution
{
    /*
        1.
        static String[] list = {"aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii",
                                "jj", "kk", "ll", "mm", "nn", "oo", "pp", "qq", "rr", "ss",
                                "tt", "uu", "vv", "ww", "xx", "yy", "zz"};
        이렇게 배열을 생성하고, 배열 안의 원소가 s에 있으면 replace로 공백으로 바꿔주었다.
        반복으로 해결하니, 정확성은 맞았지만, 효율성에서 틀렸다. 
        
        2.
        질문하기에서 스택으로 푼 풀이를 보았다. 똑같은 것이 들어오면 바로 빼주는 것이다.
        백준의 괄호 문제랑 비슷하다.
    */
    
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // s를 한번씩만 확인한다. (100만)
            // 스택이 비어있지 않고, 스택의 맨 위에 저장된 값이 c와 같다면 pop으로 빼낸다.
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else { // 스택이 비어있거나, 똑같은 문자가 아니라면 push로 넣는다.
                stack.push(c);
            }
        }
                
        return (stack.size() == 0) ? 1 : 0;
    }
}