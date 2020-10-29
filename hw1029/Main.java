package 백준_3190_뱀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, appCnt, dirCnt, X[], C[], map[][], Time, dir, dir_tail, TimeCnt;
	private static Point snake_head, snake_tail;
	private static Queue<Point> queue = new LinkedList<>();
	private static int[] di = {0, 1, 0, -1 };
	private static int[] dj = {1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = 0;
			}
		}
		st = new StringTokenizer(in.readLine());
		appCnt = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < appCnt; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int app_r = Integer.parseInt(st.nextToken()) - 1;
			int app_c = Integer.parseInt(st.nextToken()) - 1;
			map[app_r][app_c] = 2;
		}
		st = new StringTokenizer(in.readLine());
		dirCnt = Integer.parseInt(st.nextToken());
		X = new int[dirCnt + 2];
		C = new int[dirCnt + 2];
		for (int i = 1; i <= dirCnt; i++) {
			st = new StringTokenizer(in.readLine());
			X[i] = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			if (c.equals("D")) {
				C[i] = 1;
			} else if (c.equals("L")) {
				C[i] = -1;
			}
		}
		snake_head = new Point(0, 0);
		snake_tail = new Point(0, 0);
		TimeCnt = 1;
		queue.offer(new Point(0,0));
		boolean key = true;
		while (key) {
			key = OneSecondMove(key);
			Time++;
			print();
		}
		System.out.println(Time);
	}

	public static boolean OneSecondMove(boolean key) {
		if (Time == X[TimeCnt]) {
			dir = dir + C[TimeCnt];
			if(dir==4) {
				dir=0;
			}else if(dir==-1) {
				dir=3;
			}
			TimeCnt++;
		}
		if (snake_head.i + di[dir] >= 0 && snake_head.i + di[dir] < N && snake_head.j + dj[dir] >= 0
				&& snake_head.j + dj[dir] < N) {
			if (map[snake_head.i + di[dir]][snake_head.j + dj[dir]] == 1) {
				key = false;
			}
			if (map[snake_head.i + di[dir]][snake_head.j + dj[dir]] == 0) {
				map[snake_head.i + di[dir]][snake_head.j + dj[dir]] = 1;
				snake_head = new Point(snake_head.i + di[dir], snake_head.j + dj[dir]);
				queue.offer(new Point(di[dir], dj[dir]));
				Point tail = queue.poll();
				map[snake_tail.i + tail.i][snake_tail.j + tail.j] = 0;
				snake_tail = new Point(snake_tail.i + tail.i, snake_tail.j + tail.j);
			} else if (map[snake_head.i + di[dir]][snake_head.j + dj[dir]] == 2) {
				map[snake_head.i + di[dir]][snake_head.j + dj[dir]] = 1;
				queue.offer(new Point(di[dir], dj[dir]));
				snake_head = new Point(snake_head.i + di[dir], snake_head.j + dj[dir]);
			}
			return key;
		}
		key = false;
		return key;
	}

	static class Point {
		int i, j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public static void print() {
		System.out.println("appCnt:" + appCnt);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println("dirCnt:" + dirCnt);
		for (int i = 1; i <= dirCnt; i++) {
			System.out.print("X : " + X[i]);
			System.out.println(" C :" + C[i]);
		}
		System.out.println("dir : " + dir);
		System.out.println("TIME : " + Time);
	}
}
