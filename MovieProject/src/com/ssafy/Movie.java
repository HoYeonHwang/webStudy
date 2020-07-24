package com.ssafy;

public class Movie {
	private String title;
	private String director;
	private int grade;
	private String genre;
	private String summary;

	public Movie() {

	}

	public Movie(String title, String director, int grade, String genre) {

	}

	public Movie(String title, String director, int grade, String genre, String summary) {

	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}
