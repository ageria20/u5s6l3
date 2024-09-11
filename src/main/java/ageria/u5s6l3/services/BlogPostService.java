package ageria.u5s6l3.services;

import ageria.u5s6l3.controllers.BlogController;
import ageria.u5s6l3.entities.BlogPost;
import ageria.u5s6l3.exceptions.NotFoundExceptionId;
import ageria.u5s6l3.repositories.BlogPostRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Getter
@Service
public class BlogPostService {

    @Autowired
    BlogPostRepository blogPostRepository;

    public BlogPost findPostById(UUID id){
        return this.blogPostRepository.findById(id).orElseThrow(() -> new NotFoundExceptionId(id));
    }

    public void saveBlogPost(BlogPost body){
       this.blogPostRepository.save(body);
        body.setCover("https://localhost:8080/" + body.getTitle());

    }

    public BlogPost updateBlogPost(UUID blogPostId, BlogPost body){
        BlogPost found = this.findPostById(blogPostId);


                found.setCover("https://localhost:8080/" + body.getTitle());
                found.setTitle(body.getTitle());
                found.setCategory(body.getCategory());
                found.setContenuto(found.getContenuto());
                found.setReadingTime(body.getReadingTime());

        return found;
    }

    public void findyByIdAndDelete(UUID blogPostId){
        BlogPost found = this.findPostById(blogPostId);
        this.blogPostRepository.delete(found);


    }


}
