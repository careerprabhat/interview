package com.sb.interview.controller;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sb.interview.pojo.Book;
import com.sb.interview.service.BookService;

@RestController
public class BookController {
	
	@Autowired private BookService service;
	@GetMapping("/")
	public String getTest() {
		return "<html><h1>Back To Spring boot.</ h1></html>";
	}
	
	@GetMapping("/book/{id}")
	@ResponseBody
	public ResponseEntity<Book> getBook(@PathVariable("id") String id) {
		System.out.println("prabhat-------------->"+id);
		return  ResponseEntity.ok(service.findBookById(id));	
	}
	
	@GetMapping("/books")
	public Collection<Book> getAll() {
		return service.getAllBooks();
	}
	
	@PostMapping(path="/book", produces= MediaType.APPLICATION_JSON_VALUE)
	public String addBook(@RequestBody Book book) {
		service.addMap(book.getId(), book);
		return "book added : " + book.getId();
	}
	
	@PostMapping(path="/books", produces= MediaType.APPLICATION_JSON_VALUE)
	public String addAllBook(@RequestBody Book[] books) {
		service.addAllBooks(books);
		return "books are added";
	}
	
	@DeleteMapping(path="/book/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Book> deleteEmployee(@PathVariable String id){
		Book book =service.deleteBookById(id);
		if(book==null) {
			return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Book>(HttpStatus.NO_CONTENT);
	}
}
