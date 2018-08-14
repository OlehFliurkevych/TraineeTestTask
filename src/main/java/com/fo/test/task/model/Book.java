package com.fo.test.task.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fo.test.task.enumeration.GenreEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="books",indexes=@Index(columnList="name"))
public class Book{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer bookId;

	@Column(columnDefinition="text")
	private String name;
	
	@Column(columnDefinition="date")
	private Date published;
	
	private GenreEnum genre;
	
	private Integer rating;
	
	@ManyToMany
	@JoinTable(
			name="book_author",
			joinColumns=@JoinColumn(name="book_id",referencedColumnName="bookId"),
			inverseJoinColumns=@JoinColumn(name="author_id",referencedColumnName="authorId"))
	private List<Author> authors;
	
}
