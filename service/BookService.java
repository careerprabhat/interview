package com.sb.interview.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.sb.interview.pojo.Book;

@Service
public class BookService {
	
	private Map<String, Book> map = new HashMap<>();
	
	public void addMap(String key, Book value) {
		System.out.println("book added key is "+ key);
		map.put(key, value);
	}
	
	public Book findBookById(String key) {
		return map.get(key);
	}
	
	public Book deleteValue(String key) {
		return map.remove(key);
	}
	
	public Collection<Book> getAllBooks() {
		return map.values();
	}
	
	@Async
	public void addAllBooks(Book[] books) {
		for(Book book:books) {
			map.put(book.getId(), book);
		}
	}
	
	public Book getBooks(String key) {
		return map.get(key);
	}

	public Book deleteBookById(String id) {
		return map.remove(id);
	}
}
