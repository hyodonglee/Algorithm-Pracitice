//baekjoon_1620_나는야 포켓몬 마스터 이다솜

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static HashMap<String, String> hashMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=1;i<=N;i++){
            String mon = br.readLine();
            hashMap.put(Integer.toString(i), mon);
            hashMap.put(mon, Integer.toString(i));
        }
        for(int i=0;i<M;i++){
            String str = br.readLine();
            sb.append(hashMap.get(str) + "\n");
        }

        System.out.println(sb);
    }
}

