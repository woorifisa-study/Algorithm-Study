import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        int answer = 0;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c == '('){
                stack.push(c);
            }
            else{ // ')'
                if(str.charAt(i-1) == '('){
                    stack.pop();
                    answer += stack.size();
                }
                else{
                    stack.pop();
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }
}

