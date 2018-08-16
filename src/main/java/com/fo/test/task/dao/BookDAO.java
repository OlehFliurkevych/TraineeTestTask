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
	
	public Book save(Book book) {
		return bookRepository.save(book);
	}
	
	public List<Book> findAll(){
		return bookRepository.findAll();
	}
	
	public Book findOne(Long bookId) {
		return bookRepository.getOne(bookId);
	}
	
	public void delete(Book book) {
		bookRepository.delete(book);
	}
	

}
