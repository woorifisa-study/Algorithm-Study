import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int size = 4*n-3;
        for(int i=1; i<=size; i++) {
            for(int j=1; j<=size; j++) {
                int layer = Math.min(
                    Math.min(i-1, j-1), // 위, 왼쪽
                    Math.min(size-i, size-j) // 아래, 오른쪽
                );

                if(layer%2 == 0) System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
}