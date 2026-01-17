import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 문자열 쪼개기(n m 입력)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // n값 반환
        int m = Integer.parseInt(st.nextToken()); // m값 반환
        
        // 이름 -> 번호 변환만 가능
        Map<String, Integer> pokemon = new HashMap<>();
        String[] pokemonString = new String[n+1];

        for(int i=1; i<=n; i++) { // 포켓몬 도감 생성
            String pokemonName = br.readLine();
            pokemonString[i] = pokemonName;
            pokemon.put(pokemonName, i);
        }
        
        for(int i=0; i<m; i++) {
            String input = br.readLine(); // 도감 찾기
            try { // 입력을 숫자로 받았을 때
                int num = Integer.parseInt(input);
                System.out.println(pokemonString[num]);
            } catch (NumberFormatException e) { // 문자열일 때
                System.out.println(pokemon.get(input));
            }

        }
    }
}