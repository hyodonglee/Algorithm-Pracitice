/*baekjoon_15686_치킨배달*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int[] dy = { 0, -1, 0, 1 };
	static int[] dx = { 1, 0, -1, 0 };
	static ArrayList<Pair> house = new ArrayList<>();
	static ArrayList<Pair> chicken = new ArrayList<>();
	static int n, m, min = Integer.MAX_VALUE;
	static boolean valid[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);

		for (int i = 0; i < n; i++) {
			s = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				if (Integer.parseInt(s[j]) == 1)
					house.add(new Pair(i, j));
				else if (Integer.parseInt(s[j]) == 2)
					chicken.add(new Pair(i, j));
			}
		}

		valid = new boolean[chicken.size()];
		solve(0, 0);

		System.out.println(min);
	}

	public static void solve(int cnt, int start) {
		if(cnt==m) {
			min = Math.min(min, getDis());
		}
		
		for(int i=start;i<chicken.size();i++) {
			valid[i]=true;
			solve(cnt+1, i+1);
			valid[i]=false;
		}
	}

	public static int getDis() {
		int sum = 0;
		for (int i = 0; i < house.size(); i++) {
			Pair h = house.get(i);

			int mdis = Integer.MAX_VALUE;
			for (int j = 0; j < chicken.size(); j++) {
				if(!valid[j])continue;
				Pair c = chicken.get(j);
				int dis = Math.abs(c.y-h.y) + Math.abs(c.x-h.x);			
				mdis = Math.min(dis, mdis);
			}
			sum+=mdis;
		}
		return sum;
	}

	public static class Pair {
		int y, x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
