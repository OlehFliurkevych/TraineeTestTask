package com.fo.test.task.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fo.test.task.dao.BookDAO;
import com.fo.test.task.model.Book;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookDAO bookDAO;
	
	@PostMapping("/books")
	public Book createBook(@Valid @RequestBody Book book) {
		return bookDAO.save(book);
	}
	
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return bookDAO.findAll();
	}
	
	@GetMapping("/notes/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable(value="id")Integer bookId) {
		Book book=bookDAO.findOne(bookId);
		if(book==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(book);
	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable(value="id")Integer bookId,
			@Valid @RequestBody Book bookDetails){
		Book book=bookDAO.findOne(bookId);
		if(book==null) {
			return ResponseEntity.notFound().build();
		}
		book.setName(bookDetails.getName());
		book.setGenre(bookDetails.getGenre());
		book.setPublished(bookDetails.getPublished());
		book.setRating(bookDetails.getRating());
		Book updateBook=bookDAO.save(book);
		return ResponseEntity.ok().body(updateBook);
	}
	
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable(value="id")Integer bookId){
		Book book=bookDAO.findOne(bookId);
		if(book==null) {
			return ResponseEntity.notFound().build();
		}
		bookDAO.delete(book);
		return ResponseEntity.ok().build();
	}
}