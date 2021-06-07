//BOJ_9465_스티커

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int k=0;k<T;k++){
            int n = Integer.parseInt(br.readLine());
            int[][] d = new int [3][n+1];
            int[][] dp = new int[3][n+1];
            for(int i=1;i<=2;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=1;j<=n;j++){
                    d[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[1][1] = d[1][1];
            dp[2][1] = d[2][1];

            for(int j=2;j<=n;j++){
                dp[1][j] = Math.max(dp[2][j-2], dp[2][j-1])+d[1][j];
                dp[2][j] = Math.max(dp[1][j-2], dp[1][j-1])+d[2][j];
            }

            sb.append(Math.max(dp[1][n], dp[2][n])+"\n");
        }
        System.out.println(sb.toString());
    }
}