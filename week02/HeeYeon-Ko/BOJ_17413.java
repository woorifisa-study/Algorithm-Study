import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine(); // 문자열 S
        char[] strToChar = str.toCharArray();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean inTag = false; // 태그인지 아닌지

        for (int i = 0; i < str.length(); i++) {
            // '<'가 나오면 '>'가 나올 때까지 sb.append
            if(strToChar[i] == '<'){
                inTag = true;

                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }

                sb.append(strToChar[i]);
            }
            else if(strToChar[i] == '>'){
                inTag = false;
                sb.append(strToChar[i]);
            }
            // 태그안 문자열
            else if(inTag == true){
                sb.append(strToChar[i]);
            }
            // 태그밖 문자열
            else{
                // 공백일경우
                if(strToChar[i]==' '){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(strToChar[i]);
                }

                // 공백이 아닐 경우
                else{
                    stack.push(strToChar[i]);
                }
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}
