package jeeneep;
import java.io.*;

public class BOJ_20154 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int strokeCounts[] = {3, 2, 1, 2, 3, 3, 3, 3, 1, 1, 3, 1, 3, 3, 1, 2, 2, 2, 1, 2, 1, 1, 2, 2, 2, 1};
        String S = br.readLine();
        
        int sum = 0;
        for (int i = 0; i < S.length(); i++) {
            sum += strokeCounts[S.charAt(i) - 'A'];
        }
        int result = sum % 10;

        if (result % 2 == 0) System.out.println("You're the winner?");
        else System.out.println("I'm a winner!");
    }
}
