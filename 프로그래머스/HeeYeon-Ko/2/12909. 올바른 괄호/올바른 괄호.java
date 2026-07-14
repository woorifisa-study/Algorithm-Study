import java.util.*;
class Solution {
    boolean solution(String s) {
    
        Stack<Character> stack = new Stack<>();
        
        char[] ch = s.toCharArray();
        
        for(int i = 0; i<ch.length; i++){
            if(ch[i]=='('){
                stack.push(ch[i]);
            }
            else if(ch[i]==')'){
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                }
                else{
                    stack.push(ch[i]);
                }
            }
        }
        
        if(stack.isEmpty()){
            return true;
        }
        
        return false;

    }
}