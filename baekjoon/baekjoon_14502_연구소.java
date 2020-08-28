/*baekjoon_14502_연구소*/
import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int n, m;
	static boolean[][] visited;
	static int[] dy = { 0, -1, 0, 1 };
	static int[] dx = { 1, 0, -1, 0 };
	static int[][] map;
	static int[][] tempMap;
	static Queue<Pair> q;
	static int total = 0;
	static int virusCnt = 0;
	static int wallCnt=0;
	static int max;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		visited = new boolean[n][m];
		map = new int[n][m];
		tempMap = new int[n][m];
		max = 0;
		
		for(int i=0;i<n;i++) {
			s = br.readLine().split(" ");
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(s[j]);
				if(map[i][j]==1) wallCnt++;
				if(map[i][j]==2) virusCnt++;
			}
		}
		
		wall(0);
		
		System.out.println(max);
	}

	public static void wall(int cnt) {
		if(cnt==3) {
			total = 0;
			copyMap(tempMap, map);
			for(int i=0;i<n;i++)
				Arrays.fill(visited[i], false);
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(tempMap[i][j]==2 && !visited[i][j]) {
						bfs(i, j);
					}
				}
			}
			total=total+wallCnt+3;
			if(n*m-total>max) max = n*m-total;
			return;
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]==0) {
					map[i][j]=1;
					wall(cnt+1);
					map[i][j]=0;
				}
			}
		}
	}
	
	public static void copyMap(int[][] tempMap, int[][] map) {
		for(int i=0;i<n;i++) {
			tempMap[i] = map[i].clone();
		}
	}
	
	public static void bfs(int y, int x) {
		q = new LinkedList<>();
		Pair pair = new Pair(y, x);
		q.offer(pair);
		visited[y][x] = true;
		tempMap[y][x]=2;
		
		while (!q.isEmpty()) {
			pair = q.poll();
			total++;

			for (int i = 0; i < 4; i++) {
				int ny = pair.y + dy[i];
				int nx = pair.x + dx[i];

				if (!isBorder(ny, nx)) {
					if (tempMap[ny][nx]==0 && !visited[ny][nx]) {
						visited[ny][nx] = true;
						tempMap[ny][nx]=2;
						q.offer(new Pair(ny, nx));
					}
				}
			}
		}
	}

	public static boolean isBorder(int y, int x) {
		if (y < 0 || y >= n || x < 0 || x >= m) {
			return true;
		}
		return false;
	}

	public static class Pair {
		int y;
		int x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}