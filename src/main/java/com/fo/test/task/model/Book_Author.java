package com.fo.test.task.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="books_authors")
public class Book_Author {
	
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
//	@NotNull
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="book_id")
	private Book book;
	
//	@NotNull
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="author_id")
	private Author author;

	@Override
	public String toString() {
		return "Book_Author [id=" + id + ", book=" + book + ", author=" + author + "]";
	}
	
	

}
