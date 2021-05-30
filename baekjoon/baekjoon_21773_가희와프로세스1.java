//baekjoon_21773_가희와 프로세스1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int T, n;
    static PriorityQueue<Info> pq = new PriorityQueue<Info>();
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T= Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            Info info = new Info(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            pq.add(info);
        }

        int k = 1;
        while(!pq.isEmpty() && k<=T){

            Info p = pq.poll();
            p.pri--;
            p.time--;

            if(p.time>0) pq.add(p);
            k++;

            sb.append(p.id+"\n");
        }

        System.out.println(sb.toString());
    }

    private static class Info implements Comparable<Info>{
        int id;
        int time;
        int pri;

        Info(int id, int time, int pri){
            this.id = id;
            this.time = time;
            this.pri = pri;
        }

        @Override
        public int compareTo(Info o) {
            if(o.pri>this.pri) return 1;
            else if(o.pri<this.pri) return -1;
            else {
                return this.id-o.id;
            }
        }
    }
}

