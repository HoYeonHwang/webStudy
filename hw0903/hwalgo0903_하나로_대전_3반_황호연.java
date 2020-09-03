package day0903;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1251_하나로_프림_PQ {
	private static int N;
	private static long[][] adjMatrix;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T= Integer.parseInt(st.nextToken());
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] x = new int[N];
			for(int i=0;i<N;i++) {
				x[i]=Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			int[] y = new int[N];
			for(int i=0;i<N;i++) {
				y[i]=Integer.parseInt(st.nextToken());
			}
			
			adjMatrix= new long[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					adjMatrix[i][j]=adjMatrix[j][i]=getDistance(x[i],x[j],y[i],y[j]);
				}
			}
			st = new StringTokenizer(br.readLine());
			double E = Double.parseDouble(st.nextToken());
			System.out.println("#"+t+" "+Math.round(E*makeMST()));
			
		}
	}
	private static double makeMST() {
		long[] minEdge = new long[N];
		boolean[] visited = new boolean[N];
		
		long result = 0;
		int cnt = 0;
		
		Arrays.fill(minEdge, Long.MAX_VALUE);
		minEdge[0]=0;
		PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();
		pQueue.offer(new Vertex(0,minEdge[0]));
		while(true) {
			
			//1단계 : 신장트리에 포함되지 않은 정점중 최소간선비용의 정점선택
			Vertex minVertex = pQueue.poll();
			
			if(visited[minVertex.no]) continue; // 해당 정점이 이미 처리된 정점이라면
				
			visited[minVertex.no]=true;
			result = result+minVertex.cost;
			
			if(++cnt==N) break;
			
			//2단계 : 선택된 정점에서 신장트리에 포함되지 않은 다른 정점들로의 간선의 비용을 고려하여 minEdge 업데이트
			for(int i=0;i<N;i++) {
				if(!visited[i]&&adjMatrix[minVertex.no][i]>0&&minEdge[i]>adjMatrix[minVertex.no][i]) {
					minEdge[i]=adjMatrix[minVertex.no][i];
					pQueue.offer(new Vertex(i,minEdge[i]));
				}
			}
		}
		
		return result;
	}
	private static long getDistance(int x1, int x2, int y1, int y2) {
		return (long)(Math.pow((x1-x2), 2)+Math.pow((y1-y2), 2));
	}
	static class Vertex implements Comparable<Vertex>{
		int no;
		long cost;
		public Vertex(int no, long cost) {
			super();
			this.no = no;
			this.cost = cost;
		}

		@Override
		public int compareTo(Vertex o) {
			
			return Long.compare(this.cost, o.cost);
		}
	}
}
