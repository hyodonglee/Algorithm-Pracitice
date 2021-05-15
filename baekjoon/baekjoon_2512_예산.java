//baekjoon_2512_예산

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int n;
    static long[] req;
    static long highest;
    static long total = 0;
    static long maxMoney = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        req = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            req[i] = Long.parseLong(st.nextToken());
            if(highest<req[i]) highest = req[i];
        }

        st = new StringTokenizer(br.readLine());
        total = Long.parseLong(st.nextToken());

        System.out.println(binarySearch());
    }

    private static long binarySearch(){
        long mid=0;
        long s= 0;
        long e = highest;

        while(s<=e){
            long sum = 0;
            mid = (s+e)/2;
            for(int i=0;i<n;i++){
                if(req[i]>=mid){
                    sum+=mid;
                }else{
                    sum+=req[i];
                }
            }
            if(sum<=total){
                if(maxMoney<mid) maxMoney = mid;
                s=mid+1;
            }else{
                e=mid-1;
            }
        }
        return maxMoney;
    }
}