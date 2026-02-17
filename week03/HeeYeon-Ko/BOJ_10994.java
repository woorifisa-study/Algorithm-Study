import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10994 {
    static int N;
    static char[][] stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N =  Integer.parseInt(br.readLine());
        int size = 4 * N - 3;
        stars =  new char[size][size];

        // 별 찍기
        drawStars(0,0, size);

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(stars[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    // 별 찍기
    static void drawStars(int x, int y, int length){

        for (int i = x; i < x+length; i++) {
            for (int j = y; j < y+length; j++) {
                stars[i][j] = '*';
            }
        }
        outStars(x,y, length);

        length-=4;
        if(length<=0){
            return;
        }
        drawStars(x+2,y+2, length);
    }

    // 별 테두리만 남기기
    static void outStars(int x, int y, int length){
        for (int i = x+1; i < x+length-1; i++) {
            for (int j = y+1; j < y+length-1; j++) {
                stars[i][j] = ' ';
            }
        }
    }


}
