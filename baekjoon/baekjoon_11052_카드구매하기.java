//BOJ_11052_카드구매하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int n;
    static int[] P;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        P = new int[n+1];
        dp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            P[i] = Integer.parseInt(st.nextToken());
        }

        dp[0]=0;
        dp[1] = P[1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i] = Math.max(dp[i], P[j] + dp[i-j]);
            }
        }
        System.out.println(dp[n]);
    }
}