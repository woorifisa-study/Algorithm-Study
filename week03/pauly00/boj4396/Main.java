import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[][] bombList = new char[n][n];
        for (int i=0; i<n; i++) {
            String tmp = br.readLine();
            for(int j=0; j<n; j++){
                bombList[i][j] = tmp.charAt(j);
            }
        }

        char[][] usedList = new char[n][n];
        for (int i=0; i<n; i++) {
            String tmp = br.readLine();
            for(int j=0; j<n; j++){
                usedList[i][j] = tmp.charAt(j);
            }
        }

        // 주변8개 출력을 위해서
        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};
        boolean isBombOpened = false;
        for (int i=0; i<n; i++) {
            for(int j=0; j<n; j++){
                // nx=i+dx[j]; ny=i+dy[j];
                // 만약 폭탄걸림
                if(bombList[i][j]=='*' && usedList[i][j]=='x'){
                    isBombOpened = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for(int j=0;j<n; j++){
                // 지뢰 밟음(먼저)
                if(isBombOpened && bombList[i][j]=='*'){
                    System.out.print('*');
                    continue;
                }
                if (usedList[i][j] == '.'){
                    System.out.print('.');
                    continue;
                }
                int cnt = 0; // 숫자 계산
                for(int k=0; k<8; k++) {
                    int nx=i+dx[k];
                    int ny=j+dy[k];

                    if(nx<0||ny<0|| nx>=n||ny>=n) continue;
                    if(bombList[nx][ny]=='*') cnt++;
                }
                System.out.print(cnt);
            }   
            System.out.print('\n');
        }
    }
}