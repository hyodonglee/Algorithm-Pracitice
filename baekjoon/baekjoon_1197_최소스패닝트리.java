//baekjoon_1197_최소스패닝트리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{
    static int V, E;
    static ArrayList<Edge> edgeList;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edgeList = new ArrayList<>();
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(s, e, cost));
        }

        Collections.sort(edgeList);

        parent = new int[V+1];
        for(int i=1;i<=V;i++){
            parent[i] = i;
        }

        int res = 0;
        for(int k=0;k<edgeList.size();k++){
            Edge edge = edgeList.get(k);

            if(!isSameParent(edge.s, edge.e)){
                res+=edge.cost;
                union(edge.s, edge.e);
            }
        }

        System.out.println(res);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x!=y){
            parent[y]=x;
        }
    }

    static int find(int x){
        if(parent[x]==x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean isSameParent(int x, int y){
        x = find(x);
        y = find(y);

        if(x==y) return true;
        else return false;
    }

}

class Edge implements Comparable<Edge>{
    int s;
    int e;
    int cost;

    Edge(int s, int e, int cost){
        this.s = s;
        this.e = e;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost-o.cost;
    }
}