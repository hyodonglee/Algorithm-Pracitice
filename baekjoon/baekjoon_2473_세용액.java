//baekjoon_1072_게임

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int n;
    static long[] arr;
    static long[] list = new long[3];
    static long minGap=Long.MAX_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new long[n];
        for(int i=0;i<n;i++)
            arr[i] = Long.parseLong(st.nextToken());
        Arrays.sort(arr);

        //하나는 고정하고 투 포인터로 구한다.
        for(int i=0;i<n-2;i++)
            solve(i);

        Arrays.sort(list);
        for(int i=0;i<3;i++)
            System.out.print(list[i] + " ");
    }

    private static void solve(int idx){
        int s=idx+1, e=n-1;
        while(s<e){
            long sum = arr[s]+arr[e]+arr[idx];
            long gap = Math.abs(sum);

            if(minGap>gap){
                minGap = gap;
                list[0] = arr[s];
                list[1] = arr[e];
                list[2] = arr[idx];
            }

            if(sum==0) return;
            if(sum>0){
                e--;
            }else{
             s++;
            }
        }
    }
}