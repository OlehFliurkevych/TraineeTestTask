package com.fo.test.task.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fo.test.task.enumeration.GenderEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="authors",indexes=@Index(columnList="author_id"))
public class Author{
	
	@Id
	@Column(name="author_id",nullable=false,insertable=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long authorId;

	@NotBlank
	@Column(columnDefinition="text")
	private String name;
	
	@NotNull
	private GenderEnum gender;
	
	@Column(columnDefinition="date",nullable=true)
	private LocalDate born;
	
	@OneToMany(mappedBy="book")
	private List<Book_Author> book_author;


	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", name=" + name + ", gender=" + gender + ", born=" + born
				+ ", book_author=" + book_author + "]";
	}
	
	
}
