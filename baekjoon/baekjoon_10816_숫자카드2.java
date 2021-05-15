//baekjoon_10816_숫자카드2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int n, m;
    static int s, e;
    static long[] card;
    static long number;
    static long cnt;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        card = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            card[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(card);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++) {
            number = Long.parseLong(st.nextToken());
            cnt = upper_binary(number)-lower_binary(number);

            sb.append(cnt + " ");
        }

        System.out.println(sb.toString());
    }

    private static int lower_binary(long number){
        int mid, s, e;
        s= 0; e = n-1;

        while(s<e){
            mid = (s+e)/2;
            if(card[mid]>=number){
                e = mid;
            }else{
                s = mid+1;
            }
        }
        return e;
    }

    private static int upper_binary(long number){
        int mid, s, e;
        s= 0; e = n-1;

        while(s<e){
            mid = (s+e)/2;
            if(card[mid]>number){
                e = mid;
            }else{
                s = mid+1;
            }
        }
        if(card[e]==number)e++;
        return e;
    }
}