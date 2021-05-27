//baekjoon_5430_AC

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int k=0;k<t;k++){
            char[] orders = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            str = str.substring(1, str.length()-1);
            StringTokenizer st = new StringTokenizer(str, ",");

            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int s=0, e=n-1;
            boolean side = true;
            boolean flag = true;
            for(int i=0;i<orders.length;i++){
                if(orders[i] == 'R'){
                    if(side) side=false;
                    else side = true;
                }else{
                    if(s>e){
                        flag = false;
                        break;
                    }
                    if(side){
                        s++;
                    }else{
                        e--;
                    }
                }
            }

            if(!flag){
                sb.append("error\n");
                continue;
            }

            if(s==e){
                sb.append("[");
                sb.append(arr[s]);
                sb.append("]\n");
            }else if(s>e){
                sb.append("[]\n");
            }else{
                sb.append("[");

                if(side){
                    for(int i=s;i<e;i++){
                        sb.append(arr[i] + ",");
                    }
                    sb.append(arr[e]);
                }else{
                    for(int i=e;i>s;i--){
                        sb.append(arr[i] + ",");
                    }
                    sb.append(arr[s]);
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb.toString());
    }
}


