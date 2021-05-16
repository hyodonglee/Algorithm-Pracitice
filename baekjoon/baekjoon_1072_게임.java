//baekjoon_1072_게임

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static long x, y;
    static long res = 0;
    static long MAX=1000000000;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        long Z = (100*y)/x;

        if(Z>=99){
            System.out.println(-1);
            return;
        }

        res = -1;
        long s=0, e=MAX;
        while(s<=e){
            long mid = (s+e)/2;

            long tmpZ = (100*(mid+y))/(mid+x);
            if(Z>=tmpZ){
                res = mid+1;
                s = mid+1;
            }else{
                e = mid-1;
            }
        }
        System.out.println(res);
    }
}