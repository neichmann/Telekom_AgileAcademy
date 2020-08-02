package org.javacream.books.warehouse.api;

import javax.persistence.Entity;

@Entity
public class HistoryBook extends Book {

	private int century;

	public int getCentury() {
		return century;
	}

	public void setCentury(int century) {
		this.century = century;
	}
}
