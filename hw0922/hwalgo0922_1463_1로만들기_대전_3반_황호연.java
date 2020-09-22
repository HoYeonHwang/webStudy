package day0922_HW;

import java.util.Scanner;

public class Main {
	static int N;
	static int index[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		index = new int[N+1];
		index[0]=0;
		index[1]=0;
		for(int i=2;i<=N;i++) {
			index[i]=index[i-1]+1;
			if(i%2==0) {
				index[i]=Math.min(index[i], index[i/2]+1);
			}
			if(i%3==0) {
				index[i]=Math.min(index[i], index[i/3]+1);
			}
		}
		System.out.println(index[N]);
	}
	
	
}
