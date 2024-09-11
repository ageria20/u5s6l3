package ageria.u5s6l3.controllers;


import ageria.u5s5l2.entities.Author;
import ageria.u5s5l2.entities.BlogPost;
import ageria.u5s5l2.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping
    public List<Author> findAll(){
        return authorService.getAuthorList();
    }

    @GetMapping("/{authorId}")
    public Author findyById(@PathVariable int authorId){
        return authorService.findAuthorById(authorId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createAuthor(@RequestBody Author body){
        authorService.saveAuthor(body);
        return "AUTHOR CREATED";
    }

    @PutMapping("/{authorId}")
    @ResponseStatus(HttpStatus.OK)
    public String updateAuthor(@PathVariable int authorId, @RequestBody Author body){
        authorService.findByIdAndUpdate(authorId, body);
        return "AUTHRO UPDATED";
    }

    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteAuthor(@PathVariable int authorId){
        authorService.findByIdAndDelete(authorId);
        return "AUTHOR DELETED";
    }

}
