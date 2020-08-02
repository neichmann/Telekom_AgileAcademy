package org.javacream.books.warehouse.api;

import javax.persistence.Entity;

@Entity
public class Comic extends Book {

	private String hero;

	public String getHero() {
		return hero;
	}

	public void setHero(String hero) {
		this.hero = hero;
	}
	
	
}
