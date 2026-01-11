import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String password;

        while ((password = br.readLine()).equals("end") == false) {
            int vowelCnt = 0;
            int consCnt = 0;
            boolean hasVowel = false;
            char prev = 0;
            boolean ok = true;

            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);
                boolean isVowel = "aeiou".indexOf(c) != -1;

                if (isVowel) hasVowel = true;

                if (i > 0 && c == prev) {
                    if (c != 'e' && c != 'o') {
                        ok = false;
                        break;
                    }
                }

                if (isVowel) {
                    vowelCnt++;
                    consCnt = 0;
                } else {
                    consCnt++;
                    vowelCnt = 0;
                }

                if (vowelCnt == 3 || consCnt == 3) {
                    ok = false;
                    break;
                }

                prev = c;
            }

            if (!hasVowel) ok = false;

            if (ok) System.out.printf("<%s> is acceptable.%n", password);
            else System.out.printf("<%s> is not acceptable.%n", password);
        }
    }
}
