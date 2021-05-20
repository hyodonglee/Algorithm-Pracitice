//baekjoon_1806_부분합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int n, m;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+2];
        int[] sum = new int[n+2];
        st = new StringTokenizer(br.readLine());
        int total = 0;
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + arr[i];
        }

        int i=1; int j=n;
        int min = n+1;
        int rsum = sum[n];
        while(i<=j){
            if(rsum>=m){
                if(min>j-i+1){
                    min = j-i+1;
                }
                j--;
            }else{
                i++;
                j = (i+min-1>n)? n : i+min-1;
            }
            rsum = sum[j]-sum[i-1];
        }
        if(min==n+1) System.out.println(0);
        else System.out.println(min);
    }
}