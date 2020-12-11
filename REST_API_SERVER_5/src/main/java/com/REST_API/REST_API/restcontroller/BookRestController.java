package com.REST_API.REST_API.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.REST_API.REST_API.model.Author;
import com.REST_API.REST_API.model.Book;
import com.REST_API.REST_API.model.User;
import com.REST_API.REST_API.repository.BookRepository;

    
	@RestController
	@RequestMapping("/webapi")
	//@RequestMapping(value = "/")
	//, produces = { MediaType.APPLICATION_JSON_VALUE })
	public class BookRestController {
 
	      
	  @Autowired
	  BookRepository repository;

	   
	   @GetMapping("/books")
	   public Iterable<Book> getBooks() {
	   return repository.findAll();
	   }
	   
		@GetMapping(value="/books/{id}")
		public Optional<Book> getBook(@PathVariable(value = "id")Long id) {	
		Optional<Book> book = repository.findById(id);
		
			return book;
		
		}
	    
	   @PostMapping(path="/books", consumes={"application/x-www-form-urlencoded", "application/json;charset=utf-8"}, 
			   produces = "application/json;charset=utf-8") 
	   public void saveBook(@RequestBody Book book){
	       repository.save(book);
	   }
	    
	   @DeleteMapping("/books/{bookId}")
	   public void deleteBook(@PathVariable(name="bookId")Long bookId){
		   Optional<Book> book =repository.findById(bookId);
	       if(book.isPresent()) {
	    	   repository.delete(book.get());
	   }
	   }
	    
//	   @PutMapping("books/{bookId}")
//	   public void updateBook(@RequestBody Book book,
//	     @PathVariable(name="bookId")Long bookId){
//	       book.setId(bookId);
//	       book.setTitle(book.getTitle());
//	       book.setAuthor(book.getAuthor());
//	       bookservice.saveBookByBook(book);
//	    
//	   }
	    


}
