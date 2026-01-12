package jeeneep;

import java.io.*;
import java.util.*;

public class BOJ_4659 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String line;   
        while( !(line = br.readLine()).equals("end") ) {
                        
            // 조건 1: 모음 하나를 반드시 포함해야함
            boolean checkCondition1 = false;

            // 조건 2: 모음 3개 혹은 자음 3개 연속으로 오면 안됨
            boolean checkCondition2 = true;
            int countVowel = 0;
            int countConsonant = 0;

            // 조건 3: 같은 글자가 연속적으로 두번 오면 안되나, ee와 oo는 허용함
            boolean checkCondition3 = true;

            // 검사
            for (int i = 0; i < line.length(); i++) {

                char c = line.charAt(i);
                if (c == 'a' ||  c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    checkCondition1 = true;
                    countVowel++;
                    countConsonant = 0;
                } else {
                    countConsonant++;
                    countVowel = 0;
                }

                if (countVowel >= 3 || countConsonant >= 3) checkCondition2 = false;

                if (i != line.length() - 1 && c == line.charAt(i + 1) && c != 'e' && c != 'o') {
                    checkCondition3 = false;
                }

            }
            
            sb.append("<").append(line).append("> is ");
            if (checkCondition1 && checkCondition2 && checkCondition3) sb.append("acceptable.\n");
            else sb.append("not acceptable.\n");
        }   

        System.out.print(sb);        
    }
}
