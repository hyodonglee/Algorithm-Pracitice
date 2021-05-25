//baekjoon_2638_치즈

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int CHEESE = 1;
    static final int OUT = 3;

    static int count = 0;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int n, m;
    static int[][] map;
    static Queue<Node> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }//map 받기

        map[0][0]=OUT;
        q.add(new Node(0, 0));//외부공간
        while(true){
            while(!q.isEmpty()){
                Node p = q.poll();
                map[p.x][p.y]=OUT;

                for(int i=0;i<4;i++){
                    int nx = p.x + dx[i];
                    int ny = p.y + dy[i];

                    if(!isBorder(nx, ny) && map[nx][ny]==0){
                        map[nx][ny]=OUT;
                        q.add(new Node(nx, ny));
                    }
                }
            }//외부공간 모두 OUT으로 변경

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(map[i][j]==CHEESE){
                        if(isRemove(i, j)){
                            q.add(new Node(i,j));
                        }
                    }
                }
            }//사라질 치즈 모두 저장

            if(q.isEmpty()){
                System.out.println(count);
                return;
            }
            count++;
        }
    }

    private static boolean isRemove(int x, int y){
        int cnt = 0;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(map[nx][ny] == OUT) cnt++;
        }
        if(cnt>=2) return true;
        return false;
    }

    private static boolean isBorder(int x, int y){
        return(x<0 || y<0 || x>n-1 || y>m-1);
    }

    private static class Node{
        int x, y;

        private Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
