//baekjoon_12865_평범한배낭

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int n, k;
    static int[] w, v;
    static int[][] dp;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        w = new int[n+1];
        v = new int[n+1];

        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n+1][k+1];//dp는 0으로 원래 초기화 되어있다.

        for(int i=1;i<=n;i++){//i는 순서(A,B,C,D)를 의미하며, 예를 들어 A를 넣거나 뺐을 때 중에 가치가 더 높은거
            for(int j=1;j<=k;j++){//j는 가방 무게한도
                dp[i][j] = dp[i-1][j];// 이번차례에 들어오는 것을 안넣었을 때, 즉 이전 상태 가치를 그대로 가져온다는 의미

                if(j-w[i]>=0){//이번에 w를 추가했을 때, 가방 최대 무게한도를 안넘었을 때는 두 가지 케이스를 고려해야한다.
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-w[i]]+v[i]);//아까 넣어준 dp[i-1][j]와 이전꺼를 아예 빼버린 상황(j를 넘지 못할 때는 확실히 이전 w가 없다는 의미이기 때문에 d[i-1][j-w[i]] + v[j]가능)
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}