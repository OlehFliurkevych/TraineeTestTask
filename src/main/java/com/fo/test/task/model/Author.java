package com.fo.test.task.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fo.test.task.enumeration.GenderEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
@Entity
@Table(name="authors",indexes=@Index(columnList="name"))
public class Author{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="author_id")
//	@OneToOne(mappedBy="author_id", 
//            fetch = FetchType.LAZY)
	private Integer authorId;

	@Column(columnDefinition="text")
	private String name;
	
	private GenderEnum gender;
	
	@Column(columnDefinition="date")
	private Date born;
	
//	@ManyToMany(cascade=CascadeType.ALL)
//	@JoinTable(	name="authors_books",
//				joinColumns= {@JoinColumn(name="author_id")},
//				inverseJoinColumns= {@JoinColumn(name="book_id")})
//	private List<Books> books=new ArrayList<>();
	
	
}