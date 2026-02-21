import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count=0; // 케이스 개수 카운트
        
        while(true) {
            int ans=0; // 캠핑장 이용일자
            count++;
            String[] tmp = br.readLine().split(" ");
            int canUseDates = Integer.parseInt(tmp[0]); // 사용가능
            int continuousDays = Integer.parseInt(tmp[1]); // 연속
            int vacation = Integer.parseInt(tmp[2]); // 휴가일
            if(canUseDates == 0 && continuousDays==0 && vacation==0) break;
            
            if(vacation % continuousDays == 0) {
                ans+= canUseDates * (vacation / continuousDays);
            }
            else {
                ans += canUseDates * (vacation/continuousDays);
                // 사용가능이 나머지휴가보다 크면
                if(vacation % continuousDays > canUseDates)
                    ans+= canUseDates;
                // 사용가능이 나머지휴가보다 작으면
                else ans+= vacation% continuousDays;
            }

            System.out.println("Case " + count + ": " + ans);
        }
    }
}