//baekjoon_2805_나무자르기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int n;
    static long m;
    static int[] tree;
    static long h = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        tree = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            tree[i] = Integer.parseInt(st.nextToken());
            if(h<tree[i]) h = tree[i];
        }//나무입력값 받기

        long l = 0;
        long minSum = n*h;
        long maxHeight = 0;
        while(l<=h){
            long mid = (l+h)/2;
            long sum = 0;
            for(int i=0;i<tree.length;i++){
                if(tree[i]-mid>0) sum+=tree[i]-mid;
            }

            if(sum<m){
                h = mid-1;
            }
            else if(sum == m){
                maxHeight = mid;
                break;
            }
            else{
                if(sum<minSum){
                    minSum = sum;
                    maxHeight = mid;
                }
                l = mid+1;
            }
        }
        System.out.println(maxHeight);
    }
}