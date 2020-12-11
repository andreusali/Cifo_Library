package com.REST_API.REST_API.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.REST_API.REST_API.model.Lendbook;
import com.REST_API.REST_API.repository.LendbookRepository;


@RestController
@RequestMapping("/webapi")
//@RequestMapping(value = "/")
//, produces = { MediaType.APPLICATION_JSON_VALUE })
public class LendbookRestController {

      
  @Autowired
  LendbookRepository lendbookrepository;

   
   @GetMapping("/lendbooks")
   public Iterable<Lendbook> getLendbook() {
	   return lendbookrepository.findAll();
   }
    
   @PostMapping(path="/lendbooks", consumes={"application/x-www-form-urlencoded", "application/json;charset=utf-8"}, 
		   produces = "application/json;charset=utf-8") 
   public void saveLendbook(@RequestBody Lendbook lendbook){
       lendbookrepository.save(lendbook);
   }
    
   @DeleteMapping("/lendbooks/{lendbookId}")
   public void deleteLendbook(@PathVariable(name="lendbookId")Long lendbookId){
	   
	   Optional<Lendbook> lendbook = lendbookrepository.findById(lendbookId);
	   if(lendbook.isPresent()) {
       lendbookrepository.delete(lendbook.get());
	   }
   }
//    
//   @PutMapping("/authors/{authorId}")
//   public void updateAuthor(@RequestBody Author author,
//     @PathVariable(name="authorId")Long authorId){
//	   author.setId(authorId);
//	   author.setName(author.getName());
//        service.saveAuthorByAuthor(author);
//    
//   }
    

    
  
  
}
