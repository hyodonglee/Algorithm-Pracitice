//baekjoon_6087_레이저통신
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] map;
    static int[][] visited;
    static int res = 987654321;
    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int startX=0, startY=0, endX=0, endY=0;
        boolean flag = false;
        m = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);

        map = new char[n][m];
        visited = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                visited[i][j]=987654321;
        }

        for(int i=0;i<n;i++){
            String line = br.readLine();
            for(int j=0;j<m;j++){
                map[i][j] = line.charAt(j);

                if(map[i][j] == 'C'){
                    if(!flag){
                        startX = i;
                        startY = j;
                        flag = true;
                    }else{
                        endX = i;
                        endY = j;
                    }
                }
            }
        }//정보받기

        Queue<Point> q = new LinkedList<>();

        visited[startX][startY]=0;
        for(int i=0;i<4;i++){
            int nx = startX+dx[i];
            int ny = startY+dy[i];

            if(!isBorder(nx, ny) && map[nx][ny]!='*'){
                q.add(new Point(nx, ny, i, 0));
                visited[nx][ny] = 0;
            }
        }

        while(!q.isEmpty()){
            Point p = q.poll();

            if(p.x==endX && p.y==endY){
                if(res>p.mirror)
                    res = p.mirror;
                continue;
            }

            int nx = p.x+dx[p.dir];
            int ny = p.y+dy[p.dir];
            if(!isBorder(nx, ny) && visited[nx][ny]>=p.mirror && map[nx][ny]!='*'){
                visited[nx][ny]=p.mirror;
                q.add(new Point(nx, ny, p.dir, p.mirror));
            }

            int ndir = (p.dir +1)%4;
            nx = p.x+dx[ndir];
            ny = p.y+dy[ndir];
            int nmirror = p.mirror+1;
            if(!isBorder(nx, ny) && visited[nx][ny]>=nmirror && map[nx][ny]!='*'){
                visited[nx][ny]=nmirror;
                q.add(new Point(nx, ny, ndir, nmirror));
            }

            ndir = (p.dir + 3)%4;
            nx = p.x+dx[ndir];
            ny = p.y+dy[ndir];
            nmirror = p.mirror+1;
            if(!isBorder(nx, ny) && visited[nx][ny]>=nmirror && map[nx][ny]!='*'){
                visited[nx][ny]=nmirror;
                q.add(new Point(nx, ny, ndir, nmirror));
            }

        }
        System.out.println(res);
    }

    private static boolean isBorder(int x, int y){
        if(x<0 || y<0 || x>n-1 || y>m-1) return true;
        return false;
    }

    private static class Point{
        int x, y, dir, mirror;

        private Point(int x, int y, int dir, int mirror){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.mirror = mirror;
        }
    }
}
