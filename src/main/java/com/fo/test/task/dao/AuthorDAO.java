package com.fo.test.task.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fo.test.task.model.Author;
import com.fo.test.task.repository.AuthorRepository;

@Service
public class AuthorDAO {

	@Autowired
	AuthorRepository authorRepository;
	
	public Author save(Author author) {
		return authorRepository.save(author);
	}
	
	public List<Author> findAll(){
		return authorRepository.findAll();
	}
	
	public Author findOne(Long id) {
		return authorRepository.getOne(id);
	}
	
	public void delete(Author author) {
		authorRepository.delete(author);
	}
}
