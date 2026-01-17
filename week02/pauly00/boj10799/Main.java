import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String stick = br.readLine();

        int ans=0; // 출력값
        int open=0; // 열린 막대 수
        if (stick.charAt(0)=='(') open++;
        for (int i=1; i<stick.length(); i++) {
            if(stick.charAt(i) == '(') {
                open++;
            }else { // ')'가 나왔을 때
                if (stick.charAt(i-1)=='('){
                    open--; // 레이저이므로
                    ans+= open;
                }
                else{ // 시작이 ')'
                    open--;
                    ans+=1;
                }
            }
        }
        System.out.println(ans);
    }
}