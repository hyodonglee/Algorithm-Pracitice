/*baekjoon_1987_알파벳*/
import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n, m;
	static boolean[] check = new boolean[26];
	static boolean[][] visited;
	static int[] dy = { 0, -1, 0, 1 };
	static int[] dx = { 1, 0, -1, 0 };
	static int cnt = 0;
	static int max = 0;
	static int[][] map;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");

		Arrays.fill(check, false);
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);

		map = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j]=str.charAt(j)-'A';
			}
		}
		// map 생성
		dfs(0, 0);
		
		System.out.println(max);
	}

	public static void dfs(int y, int x) {
		check[map[y][x]]=true;
		visited[y][x]=true;
		cnt++;
		if(max<cnt) max = cnt;
		
		for(int i=0;i<4;i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(!isBorder(ny, nx)) {
				if(!visited[ny][nx] && !check[map[ny][nx]]) {
					dfs(ny, nx);
					cnt--;
					visited[ny][nx]=false;
					check[map[ny][nx]]=false;
				}
			}
		}
	}
	
	public static boolean isBorder(int y, int x){
		if(y<0 || y>=n || x<0 || x>=m) {
			return true;
		}
		return false;
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