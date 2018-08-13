package com.fo.test.task.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
public class Authors{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="author_id")
	@OneToOne(mappedBy="author_id", 
            fetch = FetchType.LAZY)
	private Integer authorId;

	@Column(columnDefinition="text")
	private String name;
	
	private GenderEnum gender;
	
	@Column(columnDefinition="date")
	private SimpleDateFormat born;
	
//	@ManyToMany(cascade=CascadeType.ALL)
//	@JoinTable(	name="authors_books",
//				joinColumns= {@JoinColumn(name="author_id")},
//				inverseJoinColumns= {@JoinColumn(name="book_id")})
//	private List<Books> books=new ArrayList<>();
	
	
}
