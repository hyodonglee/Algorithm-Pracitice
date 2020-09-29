/*baekjoon_17142_연구소3*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int n, m, num;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = { 0, -1, 0, 1 };
	static int[] dx = { 1, 0, -1, 0 };
	static boolean[] check;
	static int min = Integer.MAX_VALUE;
	static ArrayList<Pair> virus = new ArrayList<>();
	static ArrayList<Pair> ready = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				if (map[i][j] == 2)
					virus.add(new Pair(i, j));
				else if (map[i][j] == 0)
					num++;
			}
		}
		check = new boolean[virus.size()];

		if(num==0) {
			System.out.println(0);
			return;
		}
		solve(0,0);
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	public static void solve(int cnt, int st) {
		if (cnt == m) {
			int time = spread();
			if (min > time)
				min = time;
			return;
		}

		for (int i = st; i < virus.size(); i++) {
			if (!check[i]) {
				check[i] = true;
				ready.add(virus.get(i));
				solve(cnt + 1, i+1);
				ready.remove(virus.get(i));
				check[i] = false;
			}
		}
	}

	public static int spread() {
		int time = 0;
		int temp = num;
		
		Queue<Pair> q = new LinkedList<>();
		visited = new boolean[n][n];
		for (int i = 0; i < ready.size(); i++) {
			Pair start = ready.get(i);
			visited[start.y][start.x] = true;
			q.add(new Pair(start.y, start.x));
		}

		while (!q.isEmpty()) {
			if(min<=time) break;
			int len = q.size();
			for (int l = 0; l < len; l++) {
				Pair p = q.poll();
				for (int i = 0; i < 4; i++) {
					int ny = p.y + dy[i];
					int nx = p.x + dx[i];

					if (!isBorder(ny, nx) && map[ny][nx] !=1 && !visited[ny][nx]) {
						visited[ny][nx] = true;
						if(map[ny][nx]==0)temp--;

						q.add(new Pair(ny, nx));
					}
				}
			}
			time++;
			if (temp == 0)
				return time;
		}
		return Integer.MAX_VALUE;
	}

	public static boolean isBorder(int y, int x) {
		if (y < 0 || x < 0 || y > n - 1 || x > n - 1)
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