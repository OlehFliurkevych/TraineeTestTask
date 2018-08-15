package com.fo.test.task.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
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
//	@Column(name="id")
	private Integer bookId;

	@Column(columnDefinition="text")
	private String name;
	
	@Column(columnDefinition="date")
	private LocalDate published;
	
	private GenreEnum genre;
	
	private Integer rating;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="book")
	private List<Book_Author> book_author;

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", published=" + published + ", genre=" + genre
				+ ", rating=" + rating + ", book_author=" + book_author + "]";
	}
	
	
	
}
