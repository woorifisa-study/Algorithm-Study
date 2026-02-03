import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int k = Integer.parseInt(tmp[1]);

        String[] Stmp = br.readLine().split(" ");
        int[] S = new int[n];
        String[] Dtmp = br.readLine().split(" ");
        int[] D = new int[n];
        
        // 입력
        for(int i=0; i<n; i++) {
            S[i] = Integer.parseInt(Stmp[i]);
            D[i] = Integer.parseInt(Dtmp[i]);
        }


        for(int i=0; i<k; i++) {
            int[] temp = new int[n];

            for(int j=0; j<n; j++) {
                // D는 1부터 시작이므로, 카드 이동
                temp[D[j]-1] = S[j];
            }
            S = temp;
        }


        for(int i=0; i<n-1; i++) {
            System.out.print(S[i] + " ");
        } System.out.print(S[n-1]);
    }
}