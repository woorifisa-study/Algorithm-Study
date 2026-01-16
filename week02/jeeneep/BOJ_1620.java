package week02.jeeneep;

import java.io.*;
import java.util.*;

public class BOJ_1620 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String [] nameArr = new String[ N + 1 ];
        HashMap<String, Integer> nameMap = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            nameArr[i] = name;
            nameMap.put(name, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String str = br.readLine();

            // 입력값이 숫자
            if (Character.isDigit(str.charAt(0))) {
                sb.append(nameArr[Integer.parseInt(str)]).append('\n');
            }
            // 입력값이 이름
            else {
                sb.append(nameMap.get(str)).append('\n');
            } 
        }
        System.out.println(sb);

    }
    
}

