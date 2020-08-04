
/*baekjoon_15650_N과M(2)*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int n, m;
	static int cnt = 0;
	static boolean[] visited;
	static LinkedList<Integer>[] list;
	static ArrayList<Integer> arr;

	public static void main(String args[]) throws IOException {
		_init();

		if (m == 1)
			for (int i = 1; i <= n; i++)
				System.out.println(i);
		//m=1인 경우 계산할 필요 없으므로 단순 출력.
		
		else {
			for (int i = 1; i <= n; i++) {
				arr = new ArrayList<>();
				arr.add(i);
				visited[i]=true;
				dfs(i);
				arr.remove(arr.size()-1);
				visited[i]=false;
			}
		}
	}

	public static void _init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);

		visited = new boolean[n + 1];
		list = new LinkedList[n + 1];

		for (int i = 0; i < n + 1; i++)
			list[i] = new LinkedList<>();

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (i != j)
					list[i].add(j);
			}
		} // graph 생성완료
	}

	public static void dfs(int i) {
		if (arr.size() == m) {
			printArr();
			return;
		}

		for (int j = i-1; j < list[i].size(); j++) {
			int v = list[i].get(j);

			if (!visited[v]) {
				visited[v] = true;
				arr.add(v);
				dfs(v);
				visited[v] = false;
				arr.remove(arr.size() - 1);
			}
		}
	}
	
	public static void printArr() {
		for(int i=0;i<arr.size();i++)
			System.out.print(arr.get(i)+ " ");
		System.out.println();
	}
}