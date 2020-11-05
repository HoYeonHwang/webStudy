package SWEA_키순서;

import java.util.Scanner;

public class Main {
	private static int N, M, adj[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();

			adj = new int[N + 1][N + 1];
			for (int i = 0; i < M; i++) {
				int f = sc.nextInt();
				int s = sc.nextInt();
				adj[f][s] = 1;
			}

			for (int k = 1; k <= N; k++) { // 경유지
				for (int i = 1; i <= N; i++) {// 출발지
					if (i == k)
						continue;
					for (int j = 1; j <= N; j++) {// 도착지
						if (k == j || i == j || adj[i][j] == 1)
							continue;
						// 출발지 < 경유지 && 경유지<도착지 ==> 출발지 < 도착지
						if (adj[i][k] == 1 && adj[k][j] == 1)
							adj[i][j] = 1;
					}
				}
			}
			int answer = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; ++j) {
					adj[i][0] += adj[i][j];
					adj[0][j] += adj[i][j];
				}
			}
			for(int k=1;k<=N;k++) {
				if(adj[k][0]+adj[0][k]==N-1) answer++;
			}
			sb.append("#" + test_case + " " + answer + "\n");
		}
		System.out.println(sb);
	}
}