
/*baekjoon_7569_토마토*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n, m, l;
	static int [][][] box;
	static boolean[][][] visited;
	static Queue<Pos> q = new LinkedList<>();
	
	public static void main(String args[]) throws IOException{
		init();
		bfs();
	}
	
	public static void init() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		m = Integer.parseInt(s[0]);
		n = Integer.parseInt(s[1]);
		l = Integer.parseInt(s[2]);

		box = new int[n][m][l];
		visited = new boolean[n][m][l];
		for(int i=0;i<l;i++) {
			for(int j=0;j<n;j++) {
				s = br.readLine().split(" ");
				for(int k=0;k<m;k++) {
					box[j][k][i] = Integer.parseInt(s[k]);
					if(box[j][k][i]==1) {
						q.offer(new Pos(j, k, i, 0));
						visited[j][k][i]=true;
					}
					else if(box[j][k][i]==-1)
						visited[j][k][i]=true;
				}
			}
		}//box 채우기
		br.close();
	}
	
	public static void bfs() {
		int[] dy = {0, -1, 0, 1, 0, 0};
		int[] dx = {1, 0, -1, 0, 0, 0};
		int[] dh = {0, 0, 0, 0, -1, 1};
		int time = 0;
		while(!q.isEmpty()) {
			Pos pos = q.poll();
			int y = pos.y;
			int x = pos.x;
			int h = pos.h;
			time = pos.time;
			
			for(int i=0;i<6;i++) {
				int ny = y+dy[i];
				int nx = x+dx[i];
				int nh = h+dh[i];
				
				if(!isBorder(ny, nx, nh) && !visited[ny][nx][nh] && box[ny][nx][nh]!=-1) {
					visited[ny][nx][nh] = true;
					q.offer(new Pos(ny, nx, nh, time+1));
				}
			}
			
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				for(int k=0;k<l;k++) {
					if(visited[i][j][k]==false) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		System.out.println(time);
	}
	
	public static boolean isBorder(int y, int x, int h) {
		if(y<0 || x<0 || h<0 || y>=n || x>=m || h>=l)
			return true;
		return false;
	}
	public static class Pos{
		int y, x, h, time;
		public Pos(int y, int x, int h, int time) {
			this.y = y;
			this.x = x;
			this.h = h;
			this.time = time;
		}
	}
}