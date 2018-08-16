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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fo.test.task.enumeration.GenreEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="books",indexes=@Index(columnList="book_id"))
public class Book{
	
	@Id
	@Column(name="book_id",nullable=false,insertable=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long bookId;

	@NotBlank
	@Column(columnDefinition="text")
	private String name;
	
	@Column(columnDefinition="date",nullable=true)
	private LocalDate published;
	
	@NotNull
	private GenreEnum genre;
	
//	@Size(max=1,message="Rating must be from 1 to 5")
	private Integer rating;
	
	
//	@Fetch(FetchMode.JOIN)
//	@JoinColumn(name="book_id", referencedColumnName="book_id")
//	@OneToMany(cascade={CascadeType.ALL})
	@OneToMany(mappedBy="book")
	private List<Book_Author> book_author;

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", name=" + name + ", published=" + published + ", genre=" + genre
				+ ", rating=" + rating + ", book_author=" + book_author + "]";
	}
	
	
	
}
