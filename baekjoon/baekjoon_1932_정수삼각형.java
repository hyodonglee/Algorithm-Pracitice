import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] D;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		int n = Integer.parseInt(s);

		D = new int[n][n];

		for (int i = 0; i < n; i++)
			Arrays.fill(D[i], -1);

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int tcnt = st.countTokens();
			for (int j = 0; j < tcnt; j++) {
				D[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = n - 1; k >= 1; k--) {
			for (int t = 0; (D[k - 1][t] != -1) && t < n; t++) {
				D[k - 1][t] += Math.max(D[k][t], D[k][t + 1]);
			}
		}

		System.out.println(D[0][0]);
	}
}