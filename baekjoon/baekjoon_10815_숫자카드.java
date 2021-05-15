//baekjoon_10815_숫자카드

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
    static boolean flag=false;
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

            s=0; e=n-1;
            flag = false;
            while(s<=e){
                int mid = (s+e)/2;

                if(card[mid]==number){
                    sb.append("1 ");
                    flag = true;
                    break;
                }else if(card[mid]<number){
                    s = mid+1;
                }else{
                    e = mid-1;
                }
            }
            if(!flag)sb.append("0 ");
        }

        System.out.println(sb.toString());
    }
}