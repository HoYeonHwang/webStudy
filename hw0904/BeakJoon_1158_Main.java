package BeakJoon_1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();
		
		int N =Integer.parseInt(st.nextToken());
		int K =Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0;i<N;i++) {
			queue.add(i+1);
		}
		
		sb.append("<");
		while(!queue.isEmpty()) {
			int cur;
			for(int i=0;i<K-1;i++) {
				cur = queue.poll();
				queue.offer(cur);
			}
			cur=queue.poll();
			if(queue.isEmpty()) {
				sb.append(cur+">");
				break;
			}
			sb.append(cur+", ");
		}
		System.out.println(sb.toString());
	}
}
