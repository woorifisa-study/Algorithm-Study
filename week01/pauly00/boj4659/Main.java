// 토요일
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        boolean isAcceptable;
        boolean isVowel; // 모음 여부

        while(true) {
            isAcceptable=true;
            isVowel=false;
            str = br.readLine();
            // if (str == "end") break; // 자바에서는 이렇게 못씀
            if (str.equals("end")) break;
            
            for(int i=0; i<str.length(); i++) {
                // 조건1: 모음 포함
                int current = str.charAt(i); // 현재 문자값
                if("aeiou".indexOf(current) != -1) {
                    isVowel = true;
                }
                // 조건2: 자/모음 3개 연속 불가(같은 글자 아님)
                if(i>=2) {
                    char c1 = str.charAt(i-2);
                    char c2 = str.charAt(i-1);
                    char c3 = str.charAt(i);

                    boolean cmp1 = "aeiou".indexOf(c1) ==-1;
                    boolean cmp2 = "aeiou".indexOf(c2) ==-1;
                    boolean cmp3 = "aeiou".indexOf(c3) == -1;

                    if(cmp1 == cmp2 && cmp2 == cmp3) {
                        isAcceptable = false;
                        break;
                    }

                }
                // 조건3: e,o 제외 같은 글자 연속 2번 불가
                if(i>=1) {
                    char prev = str.charAt(i-1);
                    if(prev==str.charAt(i) && prev!='e' && prev!='o'){
                        isAcceptable=false;
                        break;
                    }
                }
            }

            System.out.print("<" + str + "> ");
            if(isAcceptable && isVowel){
                System.out.println("is acceptable.");
            }
            else {
                System.out.println("is not acceptable.");
            }
        }
    }
}