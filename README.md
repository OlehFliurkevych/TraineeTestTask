# TraineeTestTask
Pre-requirements:
  Java 8,
  MySQL,
  Hibernate/JPA,
  Spring MVC
  
Data structure:

      Books(id,name,published,genre,rating)
      
      Authors(id,name,gender,born)
      
      Books_Authors(id,book_id,author_id)
  
Tasks:
  
  1.Create basic CRUD(create/read/update/delete) for all tablets;
  
  2.Show authors which are older 55 years old and sort them by 'born' column:
  
    	@GetMapping("/older")
	    public List<Author> older55years(){
		    List<Author> authors=authorDAO.findAll();
		    List<Author> olderAuthors=new ArrayList<>();
		    for (Author author : authors) {
			    if(author.getBorn()==null)
				    continue;
			    if((LocalDate.now().getYear()-author.getBorn().getYear())>55) {
				    olderAuthors.add(author);
			    }
		    }
		    Collections.sort(olderAuthors,new AuthorComparatorASC());
		    return olderAuthors;
	    }
      
      
  3.Return books whose author has more than 1 written books:
  
    @GetMapping("/more_than_one_book")
	  public List<Book> findBooksWhichAuthorHaveMoreThanOneBook(){
		  List<Book> books=bookDAO.findAll();
		  List<Book> booksWhichAuthorHaveMoreThanOneBook=new ArrayList<>();
		  for (Book book : books) {
			  if(book.getBook_author().size()>1) {
				booksWhichAuthorHaveMoreThanOneBook.add(book);
			  }
		  }
		  return booksWhichAuthorHaveMoreThanOneBook;
	  }
  
  
  4.Find out author which has most books:
  
    @GetMapping("/most_books")
	  public ResponseEntity<Author> windAuthorWhichHasMostBooks(){
		  List<Author> authors=authorDAO.findAll();
		  Author authorWithMostBooks=authors.get(0);
		  for (Author author : authors) {
			  if(author.getBook_author().size()>authorWithMostBooks.getBook_author().size()) {
				  authorWithMostBooks=author;
			  }
		  }
		  return ResponseEntity.ok().body(authorWithMostBooks);
	  }
  
  
  5.Calculate number of books by genre:
  
    @GetMapping("/by_genre/{genre}")
	  public int numberOfBooksByGenre(@PathVariable(value="genre")GenreEnum genre) {
	  List<Book> books=bookDAO.findAll();
	  int count=0;
	  for (Book book : books) {
		  if(book.getGenre().equals(genre)) {
			  count++;
		  }
	  }
		return count;
	  }


	Examples adding book, author and books_authors(using Postman):
	
		{
			"name":"Zalyshynets. Chornyy voron",
			"genre":"HISTORICAL_NOVEL",
			"rating":"5"
		}
		
		{
			"name":"Schkliiar Vasyl Mikolauovych",
			"gender":"MALE",
			"born":"1951-06-10"
		}
		
		{
			"book":{
				"name":"Zalyshynets. Chornyy voron",
				"genre":"HISTORICAL_NOVEL",
				"rating":"5"
			},
			"author":{
				"name":"Schkliiar Vasyl Mikolauovych",
				"gender":"MALE",
				"born":"1951-06-10"
			}
		}
