package com.ssafy;

public class MovieMgr {
	private Movie[] movies = new Movie[100];
	private int index;

	public void add(Movie m) {
		movies[index]=m;
		index++;
	}
	public Movie[] search() {
		return movies;
	}

	public Movie[] search(String title) {
		int ct=0;
		Movie[] movie_search = new Movie[100];
		for(int i =0;i<index;i++) {
			if(movies[i]!=null&&movies[i].getTitle().equals(title)) {
				movie_search[ct]=movies[i];
				ct++;
			}
			
		}
		return movie_search;
	}

	public Movie[] searchDirector(String name) {
		int ct=0;
		Movie[] movie_search_name = new Movie[100];
		for(int i =0;i<index;i++) {
			if(movies[i]!=null&&movies[i].getTitle().contains(name)) {
				movie_search_name[ct]=movies[i];
				ct++;
			}
		}
		return movie_search_name;
	}

//	public Movie[] searchGenre(String genre) {
//
//	}

	public void delete(String title) {
		int ct=0;
		Movie[] movie_del = new Movie[100];
		for(int i = 0;i<index;i++) {
			if(movies[i]!=null&&movies[i].getTitle().equals(title)) {
				for(int j=i+1;j<index;j++) {
					movies[i]=movies[j];
					movies[j]=null;
					
				}
			}
		}
		index--;
	}

	public int getSize() {
		return index;
	}
}