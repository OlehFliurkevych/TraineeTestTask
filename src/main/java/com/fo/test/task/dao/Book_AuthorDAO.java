package com.fo.test.task.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fo.test.task.model.Book_Author;
import com.fo.test.task.repository.Book_AuthorRepository;

@Service
public class Book_AuthorDAO {

	@Autowired
	Book_AuthorRepository book_AuthorRepository;
	
	public Book_Author save(Book_Author book_author) {
		return book_AuthorRepository.save(book_author);
	}
	
	public List<Book_Author> findAll(){
		return book_AuthorRepository.findAll();
	}
	
	public Book_Author findOne(Long book_authorId) {
		return book_AuthorRepository.getOne(book_authorId);
	}
	
	public void delete(Book_Author book_author) {
		book_AuthorRepository.delete(book_author);
	}
}
