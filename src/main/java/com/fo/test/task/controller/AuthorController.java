package com.fo.test.task.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
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

import com.fo.test.task.comparator.AuthorComparatorASC;
import com.fo.test.task.dao.AuthorDAO;
import com.fo.test.task.model.Author;

@RestController
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	AuthorDAO authorDAO;
	
	@PostMapping("/authors")
	public Author createAuthor(@Valid @RequestBody Author author) {
		return authorDAO.save(author);
	}
	
	@GetMapping("/authors")
	public List<Author> findAll(){
		return authorDAO.findAll();
	}
	
	@GetMapping("/notes/{id}")
	public ResponseEntity<Author> getAuthorById(@PathVariable(value="id")Long authorId) {
		Author author=authorDAO.findOne(authorId);
		if(author==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(author);
	}
	
	@PutMapping("/authors/{id}")
	public ResponseEntity<Author> updateAuthor(@PathVariable(value="id")Long authorId,
			@Valid @RequestBody Author authorDetails){
		Author author=authorDAO.findOne(authorId);
		if(author==null) {
			return ResponseEntity.notFound().build();
		}
		author.setBorn(authorDetails.getBorn());
		author.setGender(authorDetails.getGender());
		author.setName(authorDetails.getName());
		Author updateAuthor=authorDAO.save(author);
		return ResponseEntity.ok().body(updateAuthor);
	}
	
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<Author> deleteAuthor(@PathVariable(value="id")Long authorId){
		Author author=authorDAO.findOne(authorId);
		if(author==null) {
			return ResponseEntity.notFound().build();
		}
		authorDAO.delete(author);
		return ResponseEntity.ok().build();
	}
	
	//Show authors which are older 55 years old and sort them by "born" column
	
	@GetMapping("/older")
	public List<Author> older55years(){
		List<Author> authors=authorDAO.findAll();
		List<Author> olderAuthors=new ArrayList<>();
		for (Author author : authors) {
			if(author.getBorn()==null)
				continue;
			if((LocalDate.now().getYear()-author.getBorn().getYear())>55) {
				olderAuthors.add(author);
			}
		}
		Collections.sort(olderAuthors,new AuthorComparatorASC());
		return olderAuthors;
	}
	
	//Find out author which has most books
	
	@GetMapping("/most_books")
	public ResponseEntity<Author> windAuthorWhichHasMostBooks(){
		List<Author> authors=authorDAO.findAll();
		Author authorWithMostBooks=authors.get(0);
		for (Author author : authors) {
			if(author.getBook_author().size()>authorWithMostBooks.getBook_author().size()) {
				authorWithMostBooks=author;
			}
		}
		return ResponseEntity.ok().body(authorWithMostBooks);
	}
	
	
	
}
