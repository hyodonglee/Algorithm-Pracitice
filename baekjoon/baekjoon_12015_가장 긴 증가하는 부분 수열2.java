//baekjoon_12015_가장 긴 증가하는 부분 수열2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    static int n;
    static ArrayList<Integer> L = new ArrayList<>();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        L.add(0);
        for(int i=1;i<=n;i++){
            if(L.size()==1 || L.get(L.size()-1)<arr[i]){
                L.add(arr[i]);
            }else{
                L.set(lower_bound(arr[i]), arr[i]);
            }
        }

        System.out.println(L.size()-1);
    }

    private static int lower_bound(int num){
        int mid;
        int s=1, e=L.size()-1;

        while(s<e){
            mid = (s+e)/2;
            if(L.get(mid)>=num){
                e = mid;
            }else{
                s = mid+1;
            }
        }
        return e;
    }
}