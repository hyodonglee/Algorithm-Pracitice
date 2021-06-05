//BOJ_2169_로봇조종하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static final int U = 0;
    static final int L = 1;
    static final int R = 2;

    static int n, m;
    static long[][] d;
    static long[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        d = new long[n+2][m+2];
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=m;j++){
                d[i][j] = Long.parseLong(st.nextToken());
            }
        }//d 받기

        dp = new long[n+2][m+2][3];
        dp[1][1][U] = dp[1][1][L] = dp[1][1][R] = d[1][1];

        for(int i=1;i<=n;i++){
            //맨 윗줄은 위에서 온다는게 말이안됨.
            if(i==1){
                for(int j=1;j<=m;j++){
                    dp[i][j][U] = dp[i][j][R] = dp[i][j][L] =
                            dp[i][j-1][L]+d[i][j];
                }
                continue;
            }

            for(int j=1;j<=m;j++){
                //1. up
                long value = dp[i-1][j][U] + d[i][j];
                value = Math.max(value, dp[i-1][j][L] + d[i][j]);
                value = Math.max(value, dp[i-1][j][R] + d[i][j]);

                dp[i][j][U] = value;
                dp[i][j][L] = value;
                dp[i][j][R] = value;
            }

            for(int j=2;j<=m;j++){
                //2. left
                dp[i][j][L] = Math.max(dp[i][j][L], dp[i][j-1][L] + d[i][j]);
                //3. right
                dp[i][m-j+1][R] = Math.max(dp[i][m-j+1][R], dp[i][m-j+2][R] + d[i][m-j+1]);
            }
        }

        long value = dp[n][m][U];
        value = Math.max(value, dp[n][m][L]);
        value = Math.max(value, dp[n][m][R]);

        System.out.println(value);
    }
}