/*baekjoon_16234_인구이동*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	static int n, l, r;
	static int map[][];
	static boolean visited[][];
	static int[] dy = { 0, -1, 0, 1 };
	static int[] dx = { 1, 0, -1, 0 };
	static int mcnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");

		n = Integer.parseInt(s[0]);
		l = Integer.parseInt(s[1]);
		r = Integer.parseInt(s[2]);
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}

		while (true) {
			Queue<Stack<Pair>> unions = new LinkedList<>();
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j]) {
						Stack<Pair> uni = bfs(i, j);
						if (uni.size() > 2) {
							unions.offer(uni);
						}
					}
				}
			}

			if (unions.size() == 0) {
				System.out.println(mcnt);
				return;
			}

			while (!unions.isEmpty()) {
				Stack<Pair> union = unions.poll();
				int sum = union.pop().y;
				int avg = sum / union.size();

				while (!union.isEmpty()) {
					Pair p = union.pop();
					map[p.y][p.x] = avg;
				}
			}
			mcnt++;
		}

	}

	public static Stack<Pair> bfs(int y, int x) {
		int sum = 0;
		Stack<Pair> uni = new Stack<>();

		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(y, x));
		visited[y][x] = true;
		uni.push(new Pair(y, x));
		sum += map[y][x];
		while (!q.isEmpty()) {
			Pair p = q.poll();

			for (int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				if (!isBorder(ny, nx) && !visited[ny][nx]) {
					int gap = Math.abs(map[ny][nx] - map[p.y][p.x]);

					if (gap >= l && gap <= r) {
						visited[ny][nx] = true;
						q.offer(new Pair(ny, nx));
						uni.push(new Pair(ny, nx));
						sum += map[ny][nx];
					}
				}
			}
		}
		uni.push(new Pair(sum, -1));
		return uni;
	}

	public static class Pair {
		int y;
		int x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static boolean isBorder(int y, int x) {
		if (y < 0 || x < 0 || y > n - 1 || x > n - 1)
			return true;
		return false;
	}
}