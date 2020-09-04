package day0904_HW;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, Answer;
	static int[][] map;
	static boolean[] visited;
	static int[] used;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		used = new int[N + 1];
		Answer = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		dfs(1, 1, 0);
		System.out.println(Answer);
	}

	private static void dfs(int now, int cnt, int dist) {
		if (cnt == N) {
			if (map[now][1] > 0 && dist + map[now][1] < Answer) {
				Answer = dist + map[now][1];
			}
			return;
		}
		if (dist >= Answer) {
			return;
		}

		visited[now] = true;
		for (int i = 2; i <= N; i++) {
			if (map[now][i] > 0 && !visited[i]) {
				dfs(i, cnt + 1, dist + map[now][i]);
			}
		}
		visited[now]=false;
	}

}
