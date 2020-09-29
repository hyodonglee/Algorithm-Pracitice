/*baekjoon_19952_인성문제있어??*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int t, n, m, obs, force;
	static int sy, sx, fy, fx;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = { 0, -1, 0, 1 };
	static int[] dx = { 1, 0, -1, 0 };


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		t = Integer.parseInt(s[0]);
		
		while(t>0) {
			s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			m = Integer.parseInt(s[1]);
			obs = Integer.parseInt(s[2]);
			force = Integer.parseInt(s[3]);
			sy = Integer.parseInt(s[4])-1;
			sx = Integer.parseInt(s[5])-1;
			fy = Integer.parseInt(s[6])-1;
			fx = Integer.parseInt(s[7])-1;

			map = new int[n][m];

			
			for(int i=0;i<obs;i++) {
				s = br.readLine().split(" ");
				int y = Integer.parseInt(s[0])-1;
				int x = Integer.parseInt(s[1])-1;
				int l = Integer.parseInt(s[2]);
				map[y][x]=l;
			}

			insat();
			t--;
		}

	}

	public static void insat() {
		Queue<Pair> q = new LinkedList<>();
		visited = new boolean[n][m];
		
		q.offer(new Pair(sy, sx));
		visited[sy][sx]=true;
		
		while(!q.isEmpty()) {
			int len = q.size();
			for(int l=0;l<len;l++) {
				Pair p = q.poll();
				
				for(int i=0;i<4;i++) {
					int ny = p.y+dy[i];
					int nx = p.x+dx[i];
					
					if(!isBorder(ny, nx) && !visited[ny][nx]) {
						if(map[ny][nx]-map[p.y][p.x]<=force) {
							visited[ny][nx]=true;
							if(ny==fy && nx==fx) {
								force--;
								if(force>=0) {
									System.out.println("잘했어!!");
									return;
								}
							}else {
								q.offer(new Pair(ny, nx));
							}
						}
					}
				}
			}	
			force--;
			
			if(force<=0) {
				System.out.println("인성 문제있어??");
				return;
			}
		}
		System.out.println("인성 문제있어??");
		return;
	}

	public static boolean isBorder(int y, int x) {
		if (y < 0 || x < 0 || y > n - 1 || x > m - 1)
			return true;
		return false;
	}

	public static class Pair {
		int y, x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}