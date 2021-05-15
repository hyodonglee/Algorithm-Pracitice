//baekjoon_1654_랜선자르기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int k;
    static int n;
    static long s=1, e=0;
    static long[] line;
    static long maxLength = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        line = new long[k];
        for(int i=0;i<k;i++) {
            line[i] = Long.parseLong(br.readLine());
            if(e<line[i]) e = line[i];
        }

        while(s<=e){
            long mid = (s+e)/2;
            long cnt = 0;
            for(int i=0;i<k;i++){
                long total = line[i];
                while(total>=mid){
                    total-=mid;
                    cnt++;
                }
            }

            if(cnt<n){
                e = mid-1;
            }else{
                if(maxLength<=mid){
                    maxLength=mid;
                }
                s = mid+1;
            }
        }
        System.out.println(maxLength);
    }
}