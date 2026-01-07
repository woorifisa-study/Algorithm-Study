import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Stack<Integer> stack = new Stack<>();

        while(N>0){
            String command = bf.readLine();
            StringTokenizer st = new StringTokenizer(command);
            // push
            if(st.nextToken().equals("push")){
                stack.push(Integer.parseInt(st.nextToken()));
            }
            // pop
            else if(command.equals("pop")){
                if(!stack.isEmpty()){
                    System.out.println(stack.pop());
                }
                else {
                    System.out.println(-1);
                }
            }
            // size
            else if(command.equals("size")){
                System.out.println(stack.size());
            }
            // empty
            else if(command.equals("empty")){
                if(stack.isEmpty()){
                    System.out.println(1);
                }
                else{
                    System.out.println(0);
                }
            }
            // top
            else if(command.equals("top")){
                if(!stack.isEmpty()){
                    System.out.println(stack.peek());
                }
                else{
                    System.out.println(-1);
                }
            }
            N--;
        }
    }
}
