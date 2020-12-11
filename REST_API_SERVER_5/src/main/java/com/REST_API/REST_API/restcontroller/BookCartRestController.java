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
import com.REST_API.REST_API.model.BookCart;
import com.REST_API.REST_API.model.User;
import com.REST_API.REST_API.repository.BookCartRepository;
import com.REST_API.REST_API.repository.BookRepository;

    
	@RestController
	@RequestMapping("/webapi")
	//@RequestMapping(value = "/")
	//, produces = { MediaType.APPLICATION_JSON_VALUE })
	public class BookCartRestController {
 
	      
	  @Autowired
	  BookCartRepository repository;

	   
	   @GetMapping("/bookcarts")
	   public Iterable<BookCart> getBookcarts() {
	   return repository.findAll();
	   }
	   
		@GetMapping(value="/bookcarts/{id}")
		public Optional<BookCart> getBookcart(@PathVariable(value = "id")Long id) {	
		Optional<BookCart> bookcart = repository.findById(id);
		
			return bookcart;
		
		}
	    
	   @PostMapping(path="/bookcarts", consumes={"application/x-www-form-urlencoded", "application/json;charset=utf-8"}, 
			   produces = "application/json;charset=utf-8") 
	   public void saveBookcart(@RequestBody BookCart bookcart){
	       repository.save(bookcart);
	   }
	    
	   @DeleteMapping("/bookcarts/{bookcartId}")
	   public void deleteBookcart(@PathVariable(name="bookcartId")Long bookcartId){
		   Optional<BookCart> bookcart =repository.findById(bookcartId);
	       if(bookcart.isPresent()) {
	    	   repository.delete(bookcart.get());
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
