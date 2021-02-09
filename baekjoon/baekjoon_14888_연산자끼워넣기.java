//baekjoon_14888_연산자끼워넣기

import java.io.*;
import java.lang.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    static int n;
    static int max=-99999999, min=99999999;
    static ArrayList<Integer> numbers = new ArrayList();
    static ArrayList<Integer> opers = new ArrayList<>();
    static boolean[] visited;
    static String operators = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str= br.readLine().split(" ");
        
        n = Integer.parseInt(str[0]);

        str = br.readLine().split(" ");

        for(int i=0;i<n;i++)
            numbers.add(Integer.parseInt(str[i]));

        str = br.readLine().split(" ");

        for(int i=0;i<4;i++){
            int k = Integer.parseInt(str[i]);

            for(int j=0;j<k;j++)
                operators = operators + (i+1);
        }
        visited = new boolean[n-1];
        perm(0);

        System.out.println(max);
        System.out.println(min);
    }


    public static void perm(int cnt){
        if(cnt>n-2){
            int sum = numbers.get(0);
            for(int j=1;j<n;j++){
                sum = calculate(sum, j);
            }

            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }

        for(int i=0;i<n-1;i++){
            if(!visited[i]){
                visited[i]=true;
                opers.add(Integer.parseInt(operators.substring(i, i+1)));
                perm(cnt+1);
                visited[i]=false;
                opers.remove(opers.size()-1);
            }
        }
    }

    public static int calculate(int sum, int idx){
        int oper = opers.get(idx-1);
        int value = numbers.get(idx);
        switch(oper){
            case 1:
                sum+=value;
                break;
            case 2:
                sum-=value;
                break;
            case 3:
                sum*=value;
                break;
            case 4:
                if(value>0){
                    sum/=value;
                }else{
                    value = -value;
                    sum/=value;
                    sum = -sum;
                }
        }

        return sum;
    }
}

