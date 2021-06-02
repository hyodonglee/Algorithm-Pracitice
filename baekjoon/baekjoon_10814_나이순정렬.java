//BOJ_10814_나이순정렬


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int n;
    static PriorityQueue<Info> q = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n=Integer.parseInt(br.readLine());

        int idx=0;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            q.add(new Info(age, name, idx++));
        }

        while(!q.isEmpty()){
            Info info = q.poll();

            sb.append(info.age + " " + info.name + "\n");
        }
        System.out.println(sb.toString());
    }

}

class Info implements Comparable<Info>{
    int age;
    String name;
    int idx;

    Info(int age, String name, int idx){
        this.age = age;
        this.name = name;
        this.idx = idx;
    }

    public int compareTo(Info o){
        if(this.age>o.age){
            return 1;
        }else if(this.age==o.age){
            return this.idx-o.idx;
        }else{
            return -1;
        }
    }

}
