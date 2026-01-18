// 금요일
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // 확장자 저장 맵, Treemap은 사전순 정렬됨
        Map<String, Integer> extension = new TreeMap<>();
        for(int i=0; i<n; i++) {
            String files = br.readLine(); // 입력받을 파일
            // .이 나오면 문자열 저장 시작
            int idx = files.lastIndexOf('.');
            // . 이후부터 문자열 추가
            String ext = files.substring(idx+1);
            // 만약 문자열이 이미 존재하면 값 추가
            extension.put(ext, extension.getOrDefault(ext, 0)+1);
        }
        // 사전순 출력
        // System.out.println(extension);
        for (String key: extension.keySet()) 
            System.out.println(key+ " " + extension.get(key));
    }
}