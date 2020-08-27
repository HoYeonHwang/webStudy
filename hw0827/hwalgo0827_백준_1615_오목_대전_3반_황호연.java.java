package day0827_HW01;

import java.util.Scanner;

public class Main {
	static int[][] grid = new int[19][19];
	static int[] di = { -1, 0, 1, 1 };
	static int[] dj = { 1, 1, 1, 0 };
	static int R, C, W;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		for (int k = 1; k <= 2; k++) {
			for (int j = 0; j < 19; j++) {
				for (int i = 0; i < 19; i++) {
					if (grid[i][j] == k) {
						Check(i, j, k);
					}
				}
			}
		}
		System.out.println(W);
		System.out.println(R + " " + C);
	}

	public static void Check(int si, int sj, int d) {
		for (int i = 0; i < 4; i++) {
			int c = 1;
			int ni = si;
			int nj = sj;
			for (int j = 1; j <= 5; j++) {
				ni = ni + di[i];
				nj = nj + dj[i];
				if (ni >= 0 && ni < 19 && nj >= 0 && nj < 19 && grid[ni][nj] == d) {
					c++;
				}
			}
			if (c == 5) {
				int ci = si - di[i];
				int cj = sj - dj[i];
				ni = ni + di[i];
				nj = nj + dj[i];
				if (ni >= 0 && ni < 19 && nj >= 0 && nj < 19) {
					if (grid[ni][nj] == d) {
						return;
					}
					if (ci >= 0 && ci < 19 && cj >= 0 && cj < 19) {
						if (grid[ci][cj] == d) {
							return;
						}
					}
				}
				R = si + 1;
				C = sj + 1;
				W = d;
				return;
			}

		}
	}
}
