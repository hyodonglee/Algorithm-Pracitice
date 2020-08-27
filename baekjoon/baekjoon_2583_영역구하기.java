
/*baekjoon_2583_영역구하기*/
import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n, m, k;
	static int x1, x2, y1, y2;
	static int[] dy = { 0, -1, 0, 1 };
	static int[] dx = { 1, 0, -1, 0 };
	static int cnt = 0;
	static boolean[][] map;
	static ArrayList<Integer> area = new ArrayList<>();
	static Queue<Pair> q = new LinkedList<>();
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");

		m = Integer.parseInt(s[0]);
		n = Integer.parseInt(s[1]);
		k = Integer.parseInt(s[2]);

		map = new boolean[m][n];

		for (int l = 0; l < k; l++) {
			s = br.readLine().split(" ");
			x1 = Integer.parseInt(s[0]);
			y1 = Integer.parseInt(s[1]);
			x2 = Integer.parseInt(s[2]);
			y2 = Integer.parseInt(s[3]);

			for (int i = y1; i < y2; i++) {
				for (int j = x1; j < x2; j++) {
					map[i][j] = true;
				}
			}
		}
		// map 생성
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(!map[i][j]) {
					area.add(bfs(i, j));
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		Collections.sort(area);
		for(int i=0;i<area.size();i++)
			System.out.print(area.get(i)+ " ");
	}

	public static int bfs(int y, int x) {
		int space=0;
		Pair pair = new Pair(y, x);
		q.offer(pair);
		map[y][x]=true;
		space++;
		
		while(!q.isEmpty()) {
			pair = q.poll();
			int	ny, nx;
			for (int i = 0; i < 4; i++) {
				ny = pair.y+dy[i];
				nx = pair.x+dx[i];
				
				if(ny>=0 && ny<m && nx>=0 && nx<n) {
					if(!map[ny][nx]) {
						q.offer(new Pair(ny, nx));
						map[ny][nx]=true;
						space++;
					}
				}
			}
		}
		
		return space;
	}
	
	public static class Pair{
		int y;
		int x;
		
		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}