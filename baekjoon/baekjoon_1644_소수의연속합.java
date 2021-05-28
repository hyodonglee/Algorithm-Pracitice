//baekjoon_1644_소수의 연속합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = getPrime(n);
        int size=list.size();

        int s=0, e=0, sum=0, cnt=0;
        while(true){
            if(sum>=n){
                sum-=list.get(s++);
            }else if(e==size){
                break;
            }
            else{
                sum+=list.get(e++);
            }
            if(sum==n) cnt++;
        }
        System.out.println(cnt);
    }

    private static ArrayList<Integer> getPrime(int N){
        boolean[] prime = new boolean[N+1];
        prime[0] = prime[1] = true;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=2;i*i<=N;i++){
            if(!prime[i]){
                for(int j=i*i;j<=N;j+=i)
                    prime[j]=true; //소수가 아닌 수 체크
            }
        }
        for(int i=1;i<=N;i++){
            if(!prime[i]) list.add(i);
        }
        return list;
    }
}