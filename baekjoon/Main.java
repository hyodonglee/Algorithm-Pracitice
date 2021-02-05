//baekjoon_3190_뱀

import java.io.*;
import java.util.*;

public class Main {
    static final int APPLE = 2;
    static final int SNAKE = 1;
    static final int L = 1;
    static final int R = -1;
    static final int MAX = 101;

    static int n, k, m;
    static int map[][];
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0 ,-1, 0};
    static int dir = 0;

    static Deque<Pair> snakes = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        map= new int[n][n];

        s = br.readLine().split(" ");
        k = Integer.parseInt(s[0]);

        for(int i=0;i<k;i++){
            s = br.readLine().split(" ");

            int x = Integer.parseInt(s[0])-1;
            int y = Integer.parseInt(s[1])-1;

            map[x][y]=APPLE;
        }//사과받기

        s = br.readLine().split(" ");
        m = Integer.parseInt(s[0]);

        snakes.add(new Pair(0, 0));
        map[0][0]=SNAKE;
        int time = 1;
        for(int i=0;i<m;i++){
            s = br.readLine().split(" ");
            int sec = Integer.parseInt(s[0]);
            char d = s[1].charAt(0);

            if(d=='L') time = move(sec, time, L);
            else time = move(sec, time, R);
        }

        time = move(MAX, time, dir);

        System.out.println(time);
    }

    public static int move(int sec, int time, int direction){
        int i;
        for(i=time;i<=sec;i++){
            Pair head = snakes.peek();
            int nx = head.x+dx[dir];
            int ny = head.y+dy[dir];

            if(!inBound(nx, ny)) return i;
            if(map[nx][ny]==SNAKE) return i;

            snakes.addFirst(new Pair(nx, ny));
            if(map[nx][ny]!=APPLE){
                Pair tail = snakes.pollLast();
                map[tail.x][tail.y]=0;
            }
            map[nx][ny] = SNAKE;

        }//sec까지
       dir = (dir+direction+4)%4;

        return i;
    }

    public static boolean inBound(int x, int y){
        return x>=0 && y>=0 && x<n && y<n;
    }

    public static class Pair{
        int x;
        int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}