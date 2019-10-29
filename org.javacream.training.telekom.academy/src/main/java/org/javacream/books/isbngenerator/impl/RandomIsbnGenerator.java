package org.javacream.books.isbngenerator.impl;

import java.util.Random;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomIsbnGenerator implements IsbnGenerator{

	private Random random;
	
	public RandomIsbnGenerator(@Value("${isbngenerator.prefix}") String prefix, @Value("${isbngenerator.suffix}")String suffix) {
		if (prefix == null || suffix ==  null) {
			throw new IllegalArgumentException ("prefix and suffix must not be null");
		}
		this.prefix = prefix;
		this.suffix = suffix;
		random = new Random(this.hashCode() + System.currentTimeMillis());
	}
	private String prefix;
	private String suffix;
	

	@Override
	public String next() {
		return prefix + Math.abs(random.nextInt()) + suffix;
	}

}
