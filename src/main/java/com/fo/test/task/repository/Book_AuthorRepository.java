package com.fo.test.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fo.test.task.model.Book_Author;

@Repository
public interface Book_AuthorRepository extends JpaRepository<Book_Author, Integer>{

}
