import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int caseNum = 0;

        while(true){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int result = 0;

            caseNum ++;
            int L = Integer.parseInt(st.nextToken()); // L일동안만
            int P = Integer.parseInt(st.nextToken()); // P일 중
            int V = Integer.parseInt(st.nextToken()); // V일짜리 휴가

            // 종료
            if(L==0 && P==0 && V==0){
                break;
            }

            StringBuilder sb = new StringBuilder();

            result += (V/P) * L;

            int remainder = V % P;
            if(remainder < L){
                result += remainder;
            }
            else{
                result += L;
            }

            sb.append("Case ").append(caseNum).append(": ").append(result);
            System.out.println(sb);
        }
    }
}
