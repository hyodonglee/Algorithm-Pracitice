/*baekjoon_14891_톱니바퀴*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static ArrayList<Integer>[] q = new ArrayList[5];
	static int[] status = { 0, 0, 0, 0, 0 };
	static boolean[] flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s;
		String str;

		for (int i = 0; i < 5; i++) {
			q[i] = new ArrayList<>();
		}
		for (int i = 1; i < 5; i++) {
			str = br.readLine();
			for (int j = 0; j < 8; j++)
				q[i].add(str.charAt(j) - '0');
		}

		int k = Integer.parseInt(br.readLine());

		for (int i = 0; i < k; i++) {
			s = br.readLine().split(" ");
			int num = Integer.parseInt(s[0]);
			int dir = Integer.parseInt(s[1]);

			flag = new boolean[5];
			check(num, dir);

			for (int j = 1; j < 5; j++) {
				if (status[j] == -1) {
					int tmp = q[j].get(0);
					q[j].add(tmp);
					q[j].remove(0);
				} else if (status[j] == 1) {
					int tmp = q[j].get(7);
					q[j].add(0, tmp);
					q[j].remove(8);
				}
			}
		}

		int sum = 0;
		for (int i = 1; i < 5; i++) {
			if (q[i].get(0) == 1) {
				sum += Math.pow(2, (double) i-1);
			}
		}

		System.out.println(sum);
	}

	public static void check(int num, int dir) {

		if (num < 0 || num > 4) {
			return;
		}
		flag[num] = true;
		int left = q[num].get(6);
		int right = q[num].get(2);

		status[num] = dir;
		if (dir == 1) {// 시계방향
			if (num - 1 >= 1 && !flag[num - 1]) {
				if (left == q[num - 1].get(2)) {
					check(num - 1, 0);
				} else {
					check(num - 1, -1);
				}
			}

			if (num + 1 <= 4 && !flag[num + 1]) {
				if (right == q[num + 1].get(6)) {
					check(num + 1, 0);
				} else {
					check(num + 1, -1);
				}
			}
		} else if (dir == -1) {// 반시계
			if (num - 1 >= 1 && !flag[num - 1]) {
				if (left == q[num - 1].get(2)) {
					check(num - 1, 0);
				} else {
					check(num - 1, 1);
				}
			}

			if (num + 1 <= 4 && !flag[num + 1]) {
				if (right == q[num + 1].get(6)) {
					check(num + 1, 0);
				} else {
					check(num + 1, 1);
				}
			}
		} else {// 정지
			if (num - 1 >= 1 && !flag[num - 1]) {
				check(num-1, 0);
			}

			if (num + 1 <= 4 && !flag[num + 1]) {
				check(num+1, 0);
			}
		}
	}

	public static int getScore() {
		int score = 0;
		for (int i = 1; i < 5; i++) {
			score += q[i].get(0);
		}
		return score;
	}

}