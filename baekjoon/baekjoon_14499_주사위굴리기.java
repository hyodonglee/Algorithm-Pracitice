/*baekjoon_14503_·Îº¿Ã»¼Ò±â*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int[][] map;
	static int[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int tCnt = 0;
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);

		s = br.readLine().split(" ");
		int y = Integer.parseInt(s[0]);
		int x = Integer.parseInt(s[1]);
		int d = Integer.parseInt(s[2]);

		map = new int[n][m];
		visited = new int[n][m];

		for (int i = 0; i < n; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}

		while (true) {
			if(visited[y][x]==0) {
				visited[y][x] = 1;
				tCnt++;
			}

			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];

				if (map[ny][nx] == 1 || visited[ny][nx] == 1) {
					cnt++;
				}
			}
			if (cnt == 4) {
				int by = y - dy[d];
				int bx = x - dx[d];

				if (map[by][bx] == 1)
					break;
				else {
					y = by;
					x = bx;
					continue;
				}
			}

			int nd = turn(d);
			int ny = y + dy[nd];
			int nx = x + dx[nd];

			if (map[ny][nx] == 0 && visited[ny][nx] == 0) {
				y = ny;
				x = nx;
			}
			d = nd;
		}
		System.out.println(tCnt);
	}

	public static int turn(int d) {
		if (d == 0)
			d = 3;
		else
			d--;
		return d;
	}
}
