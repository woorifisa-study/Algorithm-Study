import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780 {

    static int[][] paper;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        paper =  new int[N][N];
        result = new int[3]; // 정답

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(0, 0, N);

        sb.append(result[0]).append("\n").append(result[1]).append("\n").append(result[2]);
        System.out.println(sb);

    }

    // 종이의 시작점(x, y), n x n
    public static void func(int x, int y, int n){
        int num = paper[x][y];

        if(n==1){
            result[num+1]++;
        }

        else{
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    if(paper[i][j]!=num){ // 같은 수가 아닐 경우
                        func(x, y,n/3);
                        func(x+n/3, y,n/3);
                        func(x+2*n/3, y,n/3);
                        func(x, y+n/3,n/3);
                        func(x+n/3, y+n/3,n/3);
                        func(x+2*n/3, y+n/3,n/3);
                        func(x, y+2*n/3,n/3);
                        func(x+n/3, y+2*n/3,n/3);
                        func(x+2*n/3, y+2*n/3,n/3);
                        return;
                    }
                }
            }
            // 같은 수일 경우(종이)
            result[num+1]++;

        }


    }
}
