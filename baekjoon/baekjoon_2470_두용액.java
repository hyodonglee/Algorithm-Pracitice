//baekjoon_2470_두용액

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int n;
    static int[] arr;
    static int minGap = Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int s=0, e=n-1;
        int a=0, b=n-1;
        while(s<e){
            int sum = arr[s]+arr[e];
            int gap = Math.abs(arr[s]+arr[e]);

            if(minGap>=gap){
                minGap = gap;
                a=arr[s];
                b=arr[e];
            }
            if(sum>=0){
                e--;
            }else{
                s++;
            }
        }
        System.out.println(a + " " + b);
    }
}