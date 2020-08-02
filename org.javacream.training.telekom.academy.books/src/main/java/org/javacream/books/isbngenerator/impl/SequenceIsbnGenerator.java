package org.javacream.books.isbngenerator.impl;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.util.SequenceGenerator;
import org.javacream.util.audit.api.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SequenceIsbnGenerator implements IsbnGenerator{
	@Autowired private AuditService auditService;
	@Autowired private SequenceGenerator sequenceGenerator;
	public SequenceIsbnGenerator(@Value("${isbngenerator.prefix}") String prefix, @Value("${isbngenerator.suffix}")String suffix) {
		if (prefix == null || suffix ==  null) {
			throw new IllegalArgumentException ("prefix and suffix must not be null");
		}
		this.prefix = prefix;
		this.suffix = suffix;
	}
	private String prefix;
	private String suffix;
	

	@Override
	public String next() {
		int key = sequenceGenerator.nextKey();
		String isbn = prefix + key + suffix;
		auditService.audit("created isbn: " + isbn);
		return isbn;
	}
}
