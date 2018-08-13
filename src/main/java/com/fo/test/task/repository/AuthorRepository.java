package com.fo.test.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fo.test.task.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{

}
