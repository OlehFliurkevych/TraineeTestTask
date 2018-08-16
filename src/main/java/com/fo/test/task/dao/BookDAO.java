package com.fo.test.task.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fo.test.task.model.Book;
import com.fo.test.task.repository.BookRepository;

@Service
public class BookDAO {
	
	@Autowired
	BookRepository bookRepository;
	
	//save book
	
	public Book save(Book book) {
		return bookRepository.save(book);
	}
	
	//search all books
	
	public List<Book> findAll(){
		return bookRepository.findAll();
	}
	
	//get a book by id
	
	public Book findOne(Long bookId) {
		return bookRepository.getOne(bookId);
	}
	
	//delete a book
	
	public void delete(Book book) {
		bookRepository.delete(book);
	}
	

}
