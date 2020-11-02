package day1102_HW_벽돌꺠기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, W, H, map[][], arr[],cnt, Answer;
	private static int di[] = { -1, 0, 1, 0 };
	private static int dj[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			Answer = Integer.MAX_VALUE;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			boom(cnt,map); // 정해진 슈팅공간에 벽돌 없애기
			System.out.println("#"+test_case+" "+Answer);
		}
	}

	public static void shot(int[][] test_map) {
		arr = new int[W];
		for (int i = 0; i < W; i++) {
			for (int j = 0; j < H; j++) {
				if (test_map[j][i] != 0) {
					arr[i] = j;
					break;
				}
			}
		}
	}

	public static void boom(int cnt,int[][] t_map) {
		int[][] c_map = new int[H][W];
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				c_map[i][j]=t_map[i][j];
			}
		}
		if(cnt>N) {
			Answer = Math.min(Answer,calc(c_map));
			return;
		}
		shot(c_map); // 슈팅할곳 정해주기
		Queue<Point> queue = new LinkedList<Point>();
		for (int i = 0; i < W; i++) {
			queue.offer(new Point(arr[i], i,c_map[arr[i]][i]));
			while (!queue.isEmpty()) {
				Point current = queue.poll();
				int R = current.r;
				for (int r = 0; r < R; r++) {
					for (int k = 0; k < 4; k++) {
						int ni = current.i + (di[k] * r);
						int nj = current.j + (dj[k] * r);
						if (ni >= 0 && ni < H && nj >= 0 && nj < W) {
							if (c_map[ni][nj] != 0) {
								c_map[ni][nj] = 0;
								queue.offer(new Point(ni, nj,c_map[ni][nj]));
							}
						}
					}
				}
			}
			c_map = clean(c_map);
//			print(cnt,c_map);
			boom(cnt+1,c_map);
			for(int a=0;a<H;a++) {
				for(int b=0;b<W;b++) {
					c_map[a][b]=t_map[a][b];
				}
			}
		}
	}


	public static int[][] clean(int[][] test_map) {
		for(int i=H-1;i>=0;i--) {
			for(int j=0;j<W;j++) {
				if(test_map[i][j]==0&&i-1>=0) {
					test_map[i][j]=test_map[i-1][j];
					test_map[i-1][j]=0;
				}
			}
		}
		return test_map;
	}
	public static int calc(int[][] test_map) {
		int cnt=0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(test_map[i][j]!=0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	public static void print(int cnt,int[][] test_map) {
		System.out.println("***************"+cnt+"번째");
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(test_map[i][j]);
			}
			System.out.println();
		}
	}

	static class Point {
		int i, j, r;

		Point(int i, int j, int r) {
			this.i = i;
			this.j = j;
			this.r = r;
		}
	}
}
