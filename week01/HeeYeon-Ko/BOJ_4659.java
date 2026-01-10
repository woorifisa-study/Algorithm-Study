import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine();
        while(!str.equals("end")){

            char[] password = str.toCharArray();
            int vowelStraightCount = 0; // 모음 연속 수
            int consonantStraightCount = 0; // 자음 연속 수
            boolean containsVowel = false; // 모음 포함 여부
            boolean threeTimes = false; // 세번 연속 여부
            boolean twoTimes = false; // 두번 연속 여부

            for (int i = 0; i < password.length; i++) {
                if(isVowel(password[i])){ // 해당 문자가 모음이라면
                    containsVowel = true;
                    vowelStraightCount++;
                    consonantStraightCount = 0;
                }
                else{
                    consonantStraightCount++;
                    vowelStraightCount = 0;
                }

                if(vowelStraightCount >= 3 || consonantStraightCount >= 3){
                    threeTimes = true;
                    break;
                }

                if(i >= 1){ // 한 글자 이상일 경우
                    if(password[i-1] == password[i]){
                        if(password[i] == 'e' || password[i] == 'o'){
                            continue;
                        }
                        else{
                            twoTimes = true;
                            break;
                        }
                    }
                }
            }

            str = bf.readLine();
            StringBuilder sb = new StringBuilder();

            sb.append('<');
            for (char c : password) {
                sb.append(c);
            }
            sb.append("> is");

            if(!containsVowel || threeTimes || twoTimes){
                sb.append(" not");
            }

            sb.append(" acceptable.");
            System.out.println(sb);
        }

    }

    public static boolean isVowel(char c){
        if(c =='a' || c =='e' || c =='i' || c =='o' || c =='u'){
            return true; // 모음
        }
        else{
            return false; // 자음
        }
    }
}
