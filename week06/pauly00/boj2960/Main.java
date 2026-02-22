import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int k = Integer.parseInt(tmp[1]);

        // 2의 배수 먼저 찾고 값을 배열에서 지운다(boolean 활용)
        boolean[] isRemoved = new boolean[n+1];
        int removedCount=0; // 지워진 개수
        for(int i=2; i<=n; i++) {
            if(!isRemoved[i]) {
                for(int j=i; j<=n; j+=i) {
                    // 이미 지워진 수는 무시
                    if(isRemoved[j]) continue;
                    isRemoved[j] =true;
                    removedCount++;
                    
                    // k번째까지만 하면 되므로
                    if(k==removedCount) {
                        System.out.println(j);
                        //k번째가 되면 출력 후 리턴
                        return;
                    }
                }
            }
        }
    }
}