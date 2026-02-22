import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t =  Integer.parseInt(br.readLine());
        StringTokenizer st;
        long answer=0;

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int test_case =  Integer.parseInt(st.nextToken());
            int[] number = new int[test_case];
            answer = 0;

            // 배열에 숫자 삽입
            for (int j = 0; j < test_case; j++) {
                number[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < test_case-1; j++) {
                for (int k = j+1; k < test_case; k++) {
                    answer += gcd(number[j], number[k]);
                }
            }

            System.out.println(answer);
        }

    }

    public static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
}
