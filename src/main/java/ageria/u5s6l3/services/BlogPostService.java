package ageria.u5s6l3.services;

import ageria.u5s6l3.entities.Author;
import ageria.u5s6l3.entities.BlogPost;
import ageria.u5s6l3.exceptions.NotFoundExceptionId;
import ageria.u5s6l3.repositories.BlogPostRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Getter
@Service
public class BlogPostService {

    @Autowired
    BlogPostRepository blogPostRepository;

    public Page<BlogPost> getAllPosts(int pages, int elements, String sortBy){
        Pageable pageable = PageRequest.of(pages, elements, Sort.Direction.valueOf(sortBy));
        return this.blogPostRepository.findAll(pageable);
    }

    public List<BlogPost> findAll(){
        return this.blogPostRepository.findAll();
    }

    public BlogPost findPostById(UUID id){
        return this.blogPostRepository.findById(id).orElseThrow(() -> new NotFoundExceptionId(id));
    }

    public void saveBlogPost(BlogPost body){
        body.setCover("https://localhost:8080/" + body.getTitle());
       this.blogPostRepository.save(body);

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
