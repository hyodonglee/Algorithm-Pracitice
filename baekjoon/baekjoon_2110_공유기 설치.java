//beakjoon_2110_공유기설치
import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    static int n, c;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);

        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 1;
        int right = arr[n-1]-arr[0];
        int dis = 0;
        int ans = 0;

        while(left<=right){
            int mid = (left+right)/2;
            int start = arr[0];
            int cnt = 1;

            for(int i=1;i<n;i++){
                dis = arr[i]-start;
                if(mid<=dis){
                    cnt++;
                    start = arr[i];
                }
            }

            if(cnt>=c){
                left = mid+1;
                ans = mid;
            }else{
                right = mid-1;
            }
        }
        System.out.println(ans);
    }

}
