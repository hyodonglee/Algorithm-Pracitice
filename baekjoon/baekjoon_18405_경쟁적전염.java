//baekjoon_18405_경쟁적전염

import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int sec, res_x, res_y;
    static int[][] map;
    static ArrayList<Virus> list = new ArrayList<>();
    static Queue<Virus> q = new LinkedList<>();
    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);

        map = new int[n][n];

        for(int i=0;i<n;i++){
            s = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                int idx = map[i][j]=Integer.parseInt(s[j]);
                if(idx>0){
                    list.add(new Virus(i, j, idx, 0));
                }
            }
        }

        Collections.sort(list, new Comparator<Virus>(){
            @Override
            public int compare(Virus o1, Virus o2){
                return o1.num - o2.num;
            }
        });

        for(int i=0;i<list.size();i++){
            q.add(list.get(i));
        }

        s = br.readLine().split(" ");
        sec = Integer.parseInt(s[0]);
        res_x = Integer.parseInt(s[1])-1;
        res_y = Integer.parseInt(s[2])-1;

        solution(sec);
        System.out.println(map[res_x][res_y]);
    }

    public static void solution(int sec){
        while(!q.isEmpty() && mapEmpty()){
            Virus virus = q.poll();
            if(sec==virus.cnt) return;

            for(int j=0;j<4;j++){
                int nx = virus.x + dx[j];
                int ny = virus.y + dy[j];
                if(inBound(nx, ny) && map[nx][ny]==0){
                    map[nx][ny] = virus.num;
                    q.add(new Virus(nx, ny, virus.num, virus.cnt+1));
                }
            }
        }
    }

    public static boolean mapEmpty(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]==0) return true;
            }
        }
        return false;
    }
    public static boolean inBound(int x, int y){
        return x>=0 && y>=0 && x<n && y<n;
    }

    public static class Virus{
        int x;
        int y;
        int num;
        int cnt;

        public Virus(int x, int y, int num, int cnt){
            this.x = x;
            this.y = y;
            this.num = num;
            this.cnt = cnt;
        }
    }
}