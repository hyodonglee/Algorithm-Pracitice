/*baekjoon_19238_스타트택시*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n, m;
	static int fuel;
	static int add;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = { 0, -1, 0, 1 };
	static int[] dx = { 1, 0, -1, 0 };
	static int ty, tx;
	static Passenger[] passenger;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");

		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		fuel = Integer.parseInt(s[2]);

		map = new int[n][n];
		passenger = new Passenger[m+1];
		
		for (int i = 0; i < n; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				if (map[i][j] == 1)
					map[i][j] = -1;
			}
		}

		s = br.readLine().split(" ");
		ty = Integer.parseInt(s[0]) - 1;
		tx = Integer.parseInt(s[1]) - 1;

		for (int i = 1; i < m + 1; i++) {
			s = br.readLine().split(" ");
			int sy = Integer.parseInt(s[0]) - 1;
			int sx = Integer.parseInt(s[1]) - 1;
			int fy = Integer.parseInt(s[2]) - 1;
			int fx = Integer.parseInt(s[3]) - 1;

			passenger[i] = new Passenger(sy, sx, fy, fx);
			map[sy][sx] = i;
		}

		int count = 0;
		while (true) {
			ArrayList<Pair> list = getCustomer(ty, tx);

			if (list.size() == 0) {
				System.out.println(-1);
				return;
			} else {
				Collections.sort(list, new Comparator<Pair>() {
					public int compare(Pair o1, Pair o2) {
						if (o1.y < o2.y) {
							return -1;
						} else if (o1.y == o2.y) {
							if (o1.x < o2.x) {
								return -1;
							}
						}
						return 1;
					}
				});
			}

			int idx = map[list.get(0).y][list.get(0).x];
			map[list.get(0).y][list.get(0).x] = 0;
			ty = list.get(0).y;
			tx = list.get(0).x;

			add = 0;
			if (!getDestination(ty, tx, passenger[idx].fy, passenger[idx].fx)) {
				System.out.println(-1);
				return;
			}

			count++;
			if (count == m) {
				System.out.println(fuel);
				break;
			}
		}
	}

	public static ArrayList getCustomer(int y, int x) {
		ArrayList<Pair> list = new ArrayList<>();

		if (map[y][x] >= 1) {
			list.add(new Pair(y, x));
			return list;
		}

		Queue<Pair> q = new LinkedList<>();
		visited = new boolean[n][n];

		q.offer(new Pair(y, x));
		visited[y][x] = true;

		while (!q.isEmpty()) {
			int len = q.size();
			fuel--;

			boolean flag = false;

			for (int l = 0; l < len; l++) {
				Pair p = q.poll();
				for (int i = 0; i < 4; i++) {
					int ny = p.y + dy[i];
					int nx = p.x + dx[i];
					if (!isBorder(ny, nx)) {
						if (map[ny][nx] != -1 && !visited[ny][nx]) {
							if (map[ny][nx] == 0) {
								visited[ny][nx] = true;
								q.offer(new Pair(ny, nx));
							} else if (map[ny][nx] >= 1) {
								visited[ny][nx] = true;
								list.add(new Pair(ny, nx));
								flag = true;
							}
						}
					}
				}
			}

			if (flag)
				return list;

			if (fuel == 0)
				return new ArrayList<>();
		}
		return new ArrayList<>();
	}

	public static boolean getDestination(int sy, int sx, int fy, int fx) {
		Queue<Pair> q = new LinkedList<>();
		visited = new boolean[n][n];

		q.offer(new Pair(sy, sx));
		visited[sy][sx] = true;

		while (!q.isEmpty()) {
			int len = q.size();
			fuel--;
			add++;
			for (int l = 0; l < len; l++) {
				Pair p = q.poll();

				for (int i = 0; i < 4; i++) {
					int ny = p.y + dy[i];
					int nx = p.x + dx[i];

					if (!isBorder(ny, nx)) {
						if (!visited[ny][nx] && map[ny][nx] != -1) {
							if (ny == fy && nx == fx) {
								ty = ny;
								tx = nx;
								fuel += add * 2;
								return true;
							} else {
								q.offer(new Pair(ny, nx));
								visited[ny][nx] = true;
							}
						}
					}
				}
			}

			if (fuel == 0)
				return false;
		}
		return false;
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

	public static class Passenger {
		int sy, sx, fy, fx;

		public Passenger(int sy, int sx, int fy, int fx) {
			this.sy = sy;
			this.sx = sx;
			this.fy = fy;
			this.fx = fx;
		}
	}
}