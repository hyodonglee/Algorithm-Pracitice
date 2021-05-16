//baekjoon_1300_K번째 수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static int n, k;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        System.out.println(binSearch());

    }

    private static int binSearch(){
        int s=1, e=k;
        int res = 0;
        while(s<=e){
            int mid = (s+e)/2;

            int cnt = getCount(mid);

            if(cnt>=k){
                res = mid;
                e = mid-1;
            }else{
                s = mid+1;
            }
        }

        return res;
    }

    private static int getCount(int mid){
        int sum = 0;
        for(int i=1;i<=n;i++){
            int val = Math.min(mid/i, n);
            sum+=val;
        }
        return sum;
    }

}