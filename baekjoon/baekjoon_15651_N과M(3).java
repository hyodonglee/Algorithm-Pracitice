
/*baekjoon_15651_N과M(3)*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
	static int n, m;
	static LinkedList<Integer>[] list;
	static ArrayList<Integer> arr;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String args[]) throws IOException {
		_init();

		if (m == 1)
			for (int i = 1; i <= n; i++)
				System.out.println(i);
		// m=1인 경우 계산할 필요 없으므로 단순 출력.

		else {
			for (int i = 1; i <= n; i++) {
				arr = new ArrayList<>();
				arr.add(i);
				dfs(i);
				arr.remove(0);
			}
		}
		bw.flush();
		bw.close();
	}

	public static void _init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);

		list = new LinkedList[n + 1];

		for (int i = 0; i < n + 1; i++)
			list[i] = new LinkedList<>();

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				list[i].add(j);
			}
		} // graph 생성완료
		
		br.close();
	}

	public static void dfs(int i) throws IOException{
		if (arr.size() == m) {
			printArr();
			return;
		}

		for (int j = 0; j < list[i].size(); j++) {
			int v = list[i].get(j);
			arr.add(v);
			dfs(v);
			arr.remove(arr.size()-1);
		}
	}

	public static void printArr() throws IOException{
		for (int i = 0; i < arr.size(); i++)
			bw.write(String.valueOf(arr.get(i))+" ");
		bw.newLine();
	}
}