package 백준_9205_맥주마시면서걸어가기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int T,N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		for(int test_case=1;test_case<=T;test_case++) {
			N=sc.nextInt();
			boolean[] visited = new boolean[N+2];
			Point S=new Point(sc.nextInt(),sc.nextInt());
			Point[] M = new Point[N+2];
			for(int i=1;i<=N;i++) {
				M[i]=new Point(sc.nextInt(),sc.nextInt());
			}
			Point P = new Point(sc.nextInt(),sc.nextInt());
			M[0]=S;
			M[N+1]=P;
			Queue<Point> queue = new LinkedList<>();
			queue.add(S);
			visited[0]=true;
			while(!queue.isEmpty()) {
				Point cur = queue.poll();
				for(int i=1;i<N+2;i++) {
					int distx=Math.abs(cur.i-M[i].i);
					int disty=Math.abs(cur.j-M[i].j);
					if(!visited[i]&&distx+disty<=1000) {
						queue.add(M[i]);
						visited[i]=true;
					}
				}
			}
			System.out.println(visited[N+1]?"happy":"sad");
		}
	}
	public static class Point{
		int i,j;
		Point(int i,int j){
			this.i=i;
			this.j=j;
		}
	}
}
