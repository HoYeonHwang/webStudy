package com.java.first;

import java.util.Scanner;

public class CheckPoint {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("키와 몸무게를 입력해주세요");
		int tal = sc.nextInt();
		int wei = sc.nextInt();
		int bi = wei+100-tal;
		System.out.println("비만수치는 "+bi+" 입니다.");
		if(bi>0) {
			System.out.println("당신은 비만이군요?");
		}
	}
}
