//baekjoon_10844_쉬운계단수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int n;
    static long d[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        d = new long[n+1][12];
        d[1][11] = 9;
        for(int i=1;i<=9;i++) d[1][i] = 1;

        for(int i=2;i<=n;i++){
            long sum = 0;
            d[i][0] = d[i-1][1]%1000000000;
            sum+=d[i][0]%1000000000;
            for(int j=1;j<=9;j++){
                d[i][j] = d[i-1][j-1]%1000000000 + d[i-1][j+1]%1000000000;
                sum+=d[i][j]%1000000000;
            }
            d[i][11]=sum%1000000000;
        }

        System.out.println(d[n][11]);
    }
}