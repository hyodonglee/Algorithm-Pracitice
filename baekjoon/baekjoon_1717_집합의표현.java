import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] parent;
	static int n, m;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);

		parent = new int[n + 1];

		for (int i = 0; i < n + 1; i++)
			parent[i] = i;

		for (int i = 0; i < m; i++) {
			s = br.readLine().split(" ");

			int flag = Integer.parseInt(s[0]);
			int a = Integer.parseInt(s[1]);
			int b = Integer.parseInt(s[2]);

			if (flag == 0)
				union(a, b);
			else
				isSameParent(a, b);
		}
	}
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x!=y)
			parent[y]=x;
	}

	public static int find(int x) {
		//사실은 find하면서 동시에 위로 올라가면서 parent를 동일하게 만들어버리는 압축함수의 역할도 함.
		if(parent[x]==x)
			return x;
		
		return parent[x] = find(parent[x]);
	}
	
	public static void isSameParent(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x==y)
			System.out.println(("YES"));
		else
			System.out.println("NO");
	}
}