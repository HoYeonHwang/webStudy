package 백준_17143_낚시왕;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int R, C, M, Time, Human, Answer;
	private static shark map[][];
	private static Queue<shark> sList;
	private static int[] di = { 0, -1, 1, 0, 0 };
	private static int[] dj = { 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()) + 1;
		C = Integer.parseInt(st.nextToken()) + 1;
		M = Integer.parseInt(st.nextToken());
		map = new shark[R][C];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			map[r][c] = new shark(r, c, s, d, z);
		}
		while (Time < C - 1 && M > 0) {
			HumanMove();
			HumanCatch();
			SharkMove();
			Time++;
		}
		System.out.println(Answer);
	}
	private static void SharkMove() {
		sList = new LinkedList<shark>();
		for (int i = 1; i < R; i++) {
			for (int j = 1; j < C; j++) {
				if (map[i][j] != null) {
					int ni = map[i][j].r;
					int nj = map[i][j].c;
					int size = map[i][j].s;
					int d = map[i][j].d;
					int z = map[i][j].z;
					int l = 0;
					if(d==1||d==2) {
						l = size%(R*2-4);
					}else if(d==3||d==4) {
						l = size%(C*2-4);
					}
					for (int s = 0; s < l; s++) {
						if (ni+di[d] == 0 || ni+di[d] == R || nj+dj[d] == 0 || nj+dj[d] == C) { // 끝을 만나면
							if (d % 2 == 1) {
								d++;
							} else if (d % 2 == 0) {
								d--;
							}
							ni = ni + di[d] ;
							nj = nj + dj[d] ;
						}else {
							ni = ni + di[d];
							nj = nj + dj[d];
						}
					}
					map[i][j] = null;
					sList.offer(new shark(ni, nj, size, d, z));
				}
			}
		}
		int S = sList.size();
		for (int s = 0; s < S; s++) {
			shark shark = sList.poll();
			int ni = shark.r;
			int nj = shark.c;
			int size = shark.s;
			int d = shark.d;
			int z = shark.z;
			if (map[ni][nj] != null) {// 다른 상어를 만났을때
				if (map[ni][nj].z > z) { // 있던 애가 클때
					
				} else { // 내가 클떄
					map[ni][nj]=shark;
				}
			} else if (map[ni][nj] == null) {// 암것도 없을때
				sList.offer(new shark(ni, nj, size, d, z));
				map[ni][nj] = shark;
			}
		}
	}
	private static void HumanCatch() {
		for (int i = 1; i < R; i++) {
			if (map[i][Human] != null) {
				Answer = Answer + map[i][Human].z;
				map[i][Human] = null;
				return;
			}
		}
	}
	private static void HumanMove() {
		Human++;
	}
	static class shark {
		int r, c, s, d, z;
		shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
}
