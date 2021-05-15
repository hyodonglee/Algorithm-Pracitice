//beakjoon_11055_가장 큰 증가 부분 수열
import java.io.*;
import java.lang.*;

public class Main {
    static int n;
    static int arr[];
    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int max = Integer.MIN_VALUE;

        n = Integer.parseInt(s[0]);
        arr = new int[n];
        dp = new int[n];

        s = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            dp[i] = arr[i]=Integer.parseInt(s[i]);
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && dp[i]<dp[j]+arr[i]){
                    dp[i]=dp[j]+arr[i];
                }
            }
        }

        for(int k:dp){
            max = Math.max(max, k);
        }
        System.out.println(max);
    }
}
