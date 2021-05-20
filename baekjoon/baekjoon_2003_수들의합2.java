//baekjoon_2003_수들의합2

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

        arr = new int[n+1];

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        int total = 0;
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum+=arr[i];
            total = sum;
        }

        int i=0; int j=n;
        int cnt = 0;
        int sum_j = 0;
        while(i<=j){
            sum-=arr[i];
            if(sum>m) {
                i++;
            }
            else{
                if(sum==m) cnt++;
                sum_j +=arr[j];
                j--;
                i=0;
                sum = total-sum_j;
            }
        }

        System.out.println(cnt);
    }
}