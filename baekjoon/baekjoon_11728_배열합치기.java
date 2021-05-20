//baekjoon_11728_배열 합치기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int n, m;
    static int a[], b[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n];
        b = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            b[i] = Integer.parseInt(st.nextToken());
        }

        int i=0, j=0, k=0;
        StringBuilder sb = new StringBuilder();

        while(i<n && j<m){
            if(a[i]<=b[j]){
                sb.append(a[i++] + " ");
            }else{
                sb.append(b[j++] + " ");
            }
        }

        if(i==n){
            for(int t=j;t<m;t++){
                sb.append(b[t] + " ");
            }
        }else{
            for(int t=i;t<n;t++){
                sb.append(a[t] + " ");
            }
        }

        System.out.println(sb.toString());
    }
}