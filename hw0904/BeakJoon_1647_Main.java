package BeakJoon_1647;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
	// 프림  PriorityQueue 사용 버전
public class Main {

	// 선발대입니당 인접행렬로 하면 터집니당
	
	static int V, E; //노드 , 간선
	static ArrayList<Vertex> list[]; // 인접리스트

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//초기화 작업
		V = Integer.parseInt(st.nextToken()); 
		E = Integer.parseInt(st.nextToken()); 
		list = new ArrayList[V]; 
		for (int i = 0; i < V; i++) {
			list[i] = new ArrayList<>(); 
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			//무향 그래프니까
			list[x].add(new Vertex(y, c));
			list[y].add(new Vertex(x, c));
		}
		
		System.out.println(makeMST());
	}

	public static int makeMST() {
		int[] d = new int[V];
		boolean[] visited = new boolean[V];
		int result = 0;
		int cnt = 0;
		int max = 0;
		Arrays.fill(d, Integer.MAX_VALUE);
		d[0] = 0;
		//pq를 만들어서 처음꺼부터 탐색
		PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();
		pQueue.offer(new Vertex(0, d[0]));

		while (true) {
			// 작은 노드 폴
			Vertex minVertex = pQueue.poll();
			if (visited[minVertex.no]) {
				continue;
			}
			visited[minVertex.no] = true;
			max = Math.max(max, minVertex.cost);
			result = result + minVertex.cost;

			if (++cnt == V)
				break;
			//노드에 딸린 리스트 만큼돌려 보았습니다.
			for (int i = 0; i < list[minVertex.no].size(); i++) {
					if (!visited[list[minVertex.no].get(i).no] && list[minVertex.no].get(i).cost > 0 && d[list[minVertex.no].get(i).no] > list[minVertex.no].get(i).cost) {
						d[list[minVertex.no].get(i).no] = list[minVertex.no].get(i).cost;
						pQueue.offer(new Vertex(list[minVertex.no].get(i).no, d[list[minVertex.no].get(i).no]));
					}
			}
		}
		return result - max;
	}

	static class Vertex implements Comparable<Vertex> {
		int no, cost;

		public Vertex(int no, int cost) {
			this.no = no;
			this.cost = cost;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.cost - o.cost;
		}

	}
}
