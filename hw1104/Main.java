package SWEA_키순서;

import java.util.Scanner;

public class Main {
    private static int N, M, dept[][], input[],Answer;

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    int T = sc.nextInt();
    for (int test_case = 1; test_case <= T; test_case++) {
        N = sc.nextInt();
        M = sc.nextInt();
        Answer = 0;
        dept = new int[N][N];
        for(int i=0;i<N;i++) {
        	for(int j=0;j<N;j++) {
        		if(i==j) {
        			dept[i][j]=0;
        		}else {
        			dept[i][j]=9999;
        		}
        	}
        }
        for(int i=0;i<M;i++) {
        	int f= sc.nextInt()-1;
        	int s = sc.nextInt()-1;
        	dept[f][s]=1;
        }
        for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if (k == i) continue;
				for (int j = 0; j < N; j++) {
					if (k == j || i == j) continue;
					if (dept[i][j] > dept[i][k] + dept[k][j]) {
						dept[i][j] = dept[i][k] + dept[k][j];
					}
				}
			}
		}
        for (int i = 0; i < N; i++) {
			boolean flag = true;
			for (int j = 0; j < N; j++) {
				if (dept[i][j] == 9999 && dept[j][i] == 9999) {
					flag = false;
					break;
				}
			}
			if (flag) {
				Answer++;
			}
		}
        sb.append("#"+test_case+" "+Answer+"\n");
    }
    System.out.println(sb);
}
}