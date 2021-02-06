//baekjoon_18352_특정 거리의 도시 찾기

import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k, x;
    static LinkedList<Integer> graph[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);
        x = Integer.parseInt(s[3]);

        graph = new LinkedList[n+1];
        for(int i=0;i<n+1;i++){
            graph[i] = new LinkedList<>();
        }

        for(int i=0;i<m;i++){
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            graph[a].add(b);
        }//graph 생성

        ArrayList<Integer> answer = bfs();

        if(answer.size()==0) {
            System.out.println(-1);
            return;
        }
        for(int i=0;i<answer.size();i++){
            System.out.println(answer.get(i));
        }
    }

    public static ArrayList<Integer> bfs(){
        int list[] = new int[n+1];
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[n+1];
        for(int i=0;i<n+1;i++)
            visited[i]=false;

        q.add(x);
        visited[x]=true;
        while(!q.isEmpty()){
            int idx = q.poll();
            int cnt = list[idx];
            for(int i=0;i<graph[idx].size();i++){
                int j = graph[idx].get(i);
                if(!visited[j]){
                    visited[j]=true;
                    q.add(j);
                    list[j] = cnt+1;
                }
            }
        }

        for(int i=0;i<list.length;i++){
            if(list[i]==k)
                answer.add(i);
        }
        return answer;
    }
}