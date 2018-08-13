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
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fo.test.task.enumeration.GenreEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name="books",indexes=@Index(columnList="name"))
public class Books{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="book_id")
	@OneToOne(mappedBy="book_id", 
            fetch = FetchType.LAZY)
	private Integer BookId;

	@Column(columnDefinition="text")
	private String name;
	
	@Column(columnDefinition="date")
	private SimpleDateFormat published;
	
	private GenreEnum genre;
	
	private Integer rating;
	
}
