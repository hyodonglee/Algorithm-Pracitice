/*baekjoon_7562_나이트의이동*/
import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int n, k;
	static boolean[][] visited;
	static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dx = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int[][] map;
	static Queue<Pair> q;
	static int startY, startX;
	static int finishY, finishX;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		k = Integer.parseInt(s[0]);
		
		for(int l=0;l<k;l++) {
			s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			
			s = br.readLine().split(" ");
			startY = Integer.parseInt(s[0]);
			startX = Integer.parseInt(s[1]);

			s = br.readLine().split(" ");
			finishY = Integer.parseInt(s[0]);
			finishX = Integer.parseInt(s[1]);
			
			if(startY == finishY && startX == finishX)
				System.out.println(0);
			else {
				visited = new boolean[n][n];
				q = new LinkedList<Pair>();
				System.out.println(bfs(startY, startX, 0));
			}
		}
	}

	public static int bfs(int y, int x, int cnt) {
		Pair pair = new Pair(y, x, cnt);
		q.offer(pair);
		visited[y][x]=true;
		
		while(!q.isEmpty()) {
			pair = q.poll();
			
			for(int i=0;i<8;i++) {
				int ny = pair.y + dy[i];
				int nx = pair.x + dx[i];
				
				if(!isBorder(ny, nx)) {
					if(ny == finishY && nx == finishX) 
						return pair.cnt+1;
					if(!visited[ny][nx]) {
						visited[ny][nx]=true;
						q.offer(new Pair(ny, nx, pair.cnt+1));
					}
				}
			}
		}
		
		return -1;
	}
	
	public static boolean isBorder(int y, int x){
		if(y<0 || y>=n || x<0 || x>=n) {
			return true;
		}
		return false;
	}
	
	public static class Pair{
		int y;
		int x;
		int cnt;
		public Pair(int y, int x, int cnt) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}
	
}