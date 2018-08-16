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

import com.fo.test.task.dao.Book_AuthorDAO;
import com.fo.test.task.model.Book_Author;

@RestController
@RequestMapping("/book_author")
public class Book_AuthorController {
	
	@Autowired
	Book_AuthorDAO book_AuthorDAO;
	
	@PostMapping("/book_authors")
	public Book_Author createBook_Author(@Valid @RequestBody Book_Author book_author) {
		return book_AuthorDAO.save(book_author);
	}
	
	@GetMapping("/book_authors")
	public List<Book_Author> getAllBook_Authors(){
		return book_AuthorDAO.findAll();
	}
	
	@GetMapping("/notes/{id}")
	public ResponseEntity<Book_Author> getBook_authorById(@PathVariable(value="id")Long book_authorId) {
		Book_Author book_author=book_AuthorDAO.findOne(book_authorId);
		if(book_author==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(book_author);
	}
	
	@PutMapping("/book_authors/{id}")
	public ResponseEntity<Book_Author> updateBook(@PathVariable(value="id")Long bookId,
			@Valid @RequestBody Book_Author book_authorDetails){
		Book_Author book_author=book_AuthorDAO.findOne(bookId);
		if(book_author==null) {
			return ResponseEntity.notFound().build();
		}
		book_author.setAuthor(book_authorDetails.getAuthor());
		book_author.setBook(book_authorDetails.getBook());
		Book_Author updateBook_Author=book_AuthorDAO.save(book_author);
		return ResponseEntity.ok().body(updateBook_Author);
	}
	
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<Book_Author> deleteBook_Author(@PathVariable(value="id")Long book_authorId){
		Book_Author book_Author=book_AuthorDAO.findOne(book_authorId);
		if(book_Author==null) {
			return ResponseEntity.notFound().build();
		}
		book_AuthorDAO.delete(book_Author);
		return ResponseEntity.ok().build();
	}

}
