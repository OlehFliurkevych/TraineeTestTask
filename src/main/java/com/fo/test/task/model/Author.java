package com.fo.test.task.model;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fo.test.task.enumeration.GenderEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name="authors",indexes=@Index(columnList="name"))
public class Author{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer authorId;

	@Column(columnDefinition="text")
	private String name;
	
	private GenderEnum gender;
	
	@Column(columnDefinition="date")
	private Date born;
	
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="author")
	private List<Book_Author> book_author;
}
