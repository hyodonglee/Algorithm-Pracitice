//baekjoon_2146_다리만들기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int groupSize = 0;
    static int maxCnt = 201;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i=0;i<n;i++){
            String[] s = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                int value = Integer.parseInt(s[j]);
                if(value==1) map[i][j] = -1;
                else map[i][j] = 0;
            }
        }//지도입력받기

        visited = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                bfs(i, j);
            }
        }//group화 하기

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j]>0){
                    findPath(i, j);
                }
            }
        }//가장자리에 있는 좌표들만 전부 bfs돌리면서 최소 경로 찾기

        System.out.println(maxCnt);
    }

    private static void bfs(int i, int j){
        if(map[i][j]==-1 && !visited[i][j]){
            groupSize++;
            Queue<Node> q = new LinkedList<>();
            q.add(new Node(i, j, 0));
            visited[i][j]=true;

            while(!q.isEmpty()){
                Node p = q.poll();

                for(int k=0;k<4;k++){
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];

                    if(!isBorder(nx, ny)){
                        if(map[nx][ny]==-1 && !visited[nx][ny]){
                            q.add(new Node(nx, ny, p.cnt+1));
                            visited[nx][ny]=true;
                        }
                        if(map[nx][ny]==0){
                            map[p.x][p.y]=groupSize;
                        }
                    }
                }
            }
        }
    }

    private static void findPath(int i, int j){
        visited = new boolean[n][n];
        if(map[i][j]>0){
            int groupNum = map[i][j];
            Queue<Node> q = new LinkedList<>();
            q.add(new Node(i, j, 0));
            visited[i][j]=true;

            while(!q.isEmpty()){
                Node p = q.poll();

                for(int k=0;k<4;k++){
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];

                    if(!isBorder(nx, ny)){
                        if(!visited[nx][ny]){
                            if(map[nx][ny]==0){
                                q.add(new Node(nx, ny, p.cnt+1));
                                visited[nx][ny]=true;
                            }else if(map[nx][ny]>0 && map[nx][ny]!=groupNum){
                                if(p.cnt<maxCnt){
                                    maxCnt=p.cnt;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static class Node{
        int x, y, cnt;

        private Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    private static boolean isBorder(int x, int y){
        return (x<0 || y<0 || x>n-1 || y>n-1);
    }
}