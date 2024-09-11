package ageria.u5s6l3.services;

import ageria.u5s6l3.entities.Author;
import ageria.u5s6l3.entities.BlogPost;
import ageria.u5s6l3.exceptions.NotFoundExceptionId;
import ageria.u5s6l3.repositories.AuthorRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Getter
@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public Author findAuthorById(UUID id){return this.authorRepository.findById(id).orElseThrow(() -> new NotFoundExceptionId(id));};


    public void saveAuthor(Author body){
        body.setAvatar("https://localhost:8080/api/author?name=" + body.getName() + body.getSurname());
        this.authorRepository.save(body);

    }

    public Author findByIdAndUpdate(UUID id, Author body){
        Author found = this.findAuthorById(id);

                found.setName(body.getName());
                found.setSurname(body.getSurname());
                found.setEmail(body.getEmail());
                found.setBirthDate(body.getBirthDate());

        return found;
    }

    public void findByIdAndDelete(UUID id){
        Author found = this.findAuthorById(id);
        this.authorRepository.delete(found);
    }
}
