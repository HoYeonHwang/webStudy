package com.ssafy;

import java.util.Scanner;

public class MovieTest {
	public static void main(String[] args) {
		MovieMgr moviemgr = new MovieMgr();
		Scanner sc = new Scanner(System.in);
		while (true) {
			print();

			int select = sc.nextInt();
			if (select == 0) {
				break;
			}
			switch (select) {

			case 1: // 영화 정보 입력
				sc.nextLine(); // scanner오류 한줄 날려주기

				/////////////////// 값 받기
				System.out.println("영화 제목 >>");
				String title = sc.nextLine();
				System.out.println("영화 감독 >>");
				String director = sc.nextLine();
				System.out.println("영화 등급 >>");
				int grade = sc.nextInt();
				sc.nextLine();
				System.out.println("영화 종류 >>");
				String genre = sc.nextLine();
				System.out.println("영화 요약 >>");
				String summary = sc.nextLine();
				///////////

				/////////// setter 이용 값 전달
				Movie movies = new Movie();
				movies.setTitle(title);
				movies.setDirector(director);
				movies.setGrade(grade);
				movies.setGenre(genre);
				movies.setSummary(summary);

				////////// 값 add
				moviemgr.add(movies);
				break;
			case 2: // 영화 정보 전체 검색
				Movie[] movie = moviemgr.search();
				for (int i = 0; i < movie.length; i++) {
					if (movie[i] != null) {
						System.out.println("-----------");
						System.out.println("1.영화 제목 : " + movie[i].getTitle());
						System.out.println("2.영화 감독 : " + movie[i].getDirector());
						System.out.println("3.영화 등급 : " + movie[i].getGrade());
						System.out.println("4.영화 종류 : " + movie[i].getGenre());
						System.out.println("5.영화 요약 : " + movie[i].getSummary());
						System.out.println("-----------");
					}

				}
				break;
			case 3:
				sc.nextLine(); // scanner오류 한줄 날려주기
				System.out.println("검색할 영화 제목 >>");
				String search_title = sc.nextLine();
				Movie[] movie_title = moviemgr.search(search_title);
				for (int i = 0; i < movie_title.length; i++) {
					if (movie_title[i] != null && movie_title[i].getTitle().contains(search_title)) {
						System.out.println("-----------");
						System.out.println("1.영화 제목 : " + movie_title[i].getTitle());
						System.out.println("2.영화 감독 : " + movie_title[i].getDirector());
						System.out.println("3.영화 등급 : " + movie_title[i].getGrade());
						System.out.println("4.영화 종류 : " + movie_title[i].getGenre());
						System.out.println("5.영화 요약 : " + movie_title[i].getSummary());
						System.out.println("-----------");
					} else if (movie_title[i] == null && movie_title[i].getTitle().contains(search_title) == false) {
						System.out.println("찾으시는 영화가 없습니다.");
						break;
					}
				}
				break;
			case 4:
				sc.nextLine(); // scanner오류 한줄 날려주기
				System.out.println("검색할 영화 감독 >>");
				String search_dir = sc.nextLine();
				Movie[] movie_dir = moviemgr.searchDirector(search_dir);
				for (int i = 0; i < movie_dir.length; i++) {
					if (movie_dir[i] != null) {
						System.out.println("-----------");
						System.out.println("1.영화 제목 : " + movie_dir[i].getTitle());
						System.out.println("2.영화 감독 : " + movie_dir[i].getDirector());
						System.out.println("3.영화 등급 : " + movie_dir[i].getGrade());
						System.out.println("4.영화 종류 : " + movie_dir[i].getGenre());
						System.out.println("5.영화 요약 : " + movie_dir[i].getSummary());
						System.out.println("-----------");
					} else if (movie_dir[i] == null) {
						System.out.println("찾으시는 영화가 없습니다.");
						break;
					}
				}
				break;
			case 5:
				sc.nextLine(); // scanner오류 한줄 날려주기
				System.out.println("삭제할 영화 감독 >>");
				String delete_title = sc.nextLine();
				moviemgr.delete(delete_title);
				break;

			case 6:
				System.out.println(moviemgr.getSize());
				break;
			}
		}
	}

	public static void print() {
		System.out.println("<<< 영화 관리 프로그램 >>>");
		System.out.println("1. 영화 정보 입력");
		System.out.println("2. 영화 정보 전체 검색");
		System.out.println("3. 영화명 검색");
		System.out.println("4. 영화 장르별 검색");
		System.out.println("5. 영화 정보 삭제");
		System.out.println("6. 영화 정보 사이즈");
		System.out.println("0. 종료");
	}
}
