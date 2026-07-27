import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            
            char c = s.charAt(i);
            
            if (c == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }           
            else {
                stack.push(c);
            }
        }
        
        if (!stack.isEmpty()) answer = false; 
        
        return answer;
    }
}