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
import com.REST_API.REST_API.model.Lend;
import com.REST_API.REST_API.model.Lendbook;
import com.REST_API.REST_API.repository.LendRepository;
import com.REST_API.REST_API.repository.UserRepository;


@RestController
@RequestMapping("/webapi")
//@RequestMapping(value = "/")
//, produces = { MediaType.APPLICATION_JSON_VALUE })
public class LendRestController {
      
  @Autowired 
  LendRepository lendrepository;
  
   @GetMapping("/lends")
   public Iterable<Lend> getLends() {
	   return lendrepository.findAll();
    
   }
    
   @PostMapping(path="/lends", consumes={"application/x-www-form-urlencoded", "application/json;charset=utf-8"}, 
		   produces = "application/json;charset=utf-8") 
   public void saveLend(@RequestBody Lend lend){
       lendrepository.save(lend);
   }
    
   @DeleteMapping("/lends/{lendId}")
   public void deleteLend(@PathVariable(name="lendId")Long lendId){
	   Optional<Lend> lend = lendrepository.findById(lendId);
	   if(lend.isPresent()) {
       lendrepository.delete(lend.get());
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
