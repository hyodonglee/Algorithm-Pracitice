/*baekjoon_5014_스타트링크*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int f, s, g, u, d;
	static boolean visited[];
	static Queue<Pair> q = new LinkedList<>();
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		f = Integer.parseInt(str[0]);
		s = Integer.parseInt(str[1]);
		g = Integer.parseInt(str[2]);
		u = Integer.parseInt(str[3]);
		d = Integer.parseInt(str[4]);
		
		visited = new boolean[f+1];
		
		if(!elevator(s))
			System.out.println("use the stairs");
	}
	
	public static boolean elevator(int floor) {
		q.offer(new Pair(floor, 0));
		visited[floor]=true;
		
		while(!q.isEmpty()) {
			Pair pair = q.poll();
			
			if(pair.floor==g) {
				System.out.println(pair.cnt);
				return true;
			}
			if(!isBorder(pair.floor+u) && !visited[pair.floor+u]) {
				visited[pair.floor+u]=true;
				q.offer(new Pair(pair.floor+u, pair.cnt+1));
			}
			
			if(!isBorder(pair.floor-d) && !visited[pair.floor-d]) {
				visited[pair.floor-d]=true;
				q.offer(new Pair(pair.floor-d, pair.cnt+1));
			}
		}
		return false;
	}
	
	public static boolean isBorder(int floor) {
		if(floor>f || floor<=0)return true;
		return false;
	}
	
	public static class Pair{
		int floor;
		int cnt;
		
		public Pair(int floor, int cnt) {
			this.floor = floor;
			this.cnt = cnt;
		}
	}
}
