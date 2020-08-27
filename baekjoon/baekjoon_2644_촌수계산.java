/*baekjoon_2644_촌수계산*/
import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	static int n, m;
	static int p1, p2;
	static boolean[] visited;
	static int cnt = 0;
	static int real = 0;
	static boolean flag = false;
	static ArrayList<Integer>[] list;
 	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");

		n = Integer.parseInt(s[0]);
		s = br.readLine().split(" ");
		p1 = Integer.parseInt(s[0]);
		p2 = Integer.parseInt(s[1]);
		s = br.readLine().split(" ");
		m = Integer.parseInt(s[0]);
		
		visited = new boolean[n+1];
		list = new ArrayList[n+1];
		for(int i=0;i<n+1;i++)
			list[i]=new ArrayList<>();
		
		for(int i=0;i<m;i++) {
			s = br.readLine().split(" ");
			int v1 = Integer.parseInt(s[0]);
			int v2 = Integer.parseInt(s[1]);
			
			list[v1].add(v2);
			list[v2].add(v1);
		}
		
		dfs(p1);
		
		if(flag)
			System.out.println(real);
		else
			System.out.println(-1);
	}
 	
 	public static void dfs(int v) {
 		if(v==p2) {
 			flag = true;
 			real = cnt;
 			return;
 		}
 		
 		visited[v]=true;
	 	cnt++;

 		int sz = list[v].size();
 		for(int i=0;i<sz;i++) {
 			if(!visited[list[v].get(i)]) {
 		 		visited[list[v].get(i)]=true;
 				dfs(list[v].get(i));
 				cnt--;
 				if(flag) return;
 			}
 		}

 	}
}