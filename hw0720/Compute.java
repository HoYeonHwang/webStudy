package com.java.first;

import java.util.Scanner;

public class Compute {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("두개의 정수를 입력해주세요");
		int fir = sc.nextInt();
		int sec = sc.nextInt();
		System.out.println("곱 = "+fir*sec+" 몫 = "+fir/sec);
	}
}
