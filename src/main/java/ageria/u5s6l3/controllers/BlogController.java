package ageria.u5s6l3.controllers;

import ageria.u5s6l3.entities.BlogPost;
import ageria.u5s6l3.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogController {

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping()
    public List<BlogPost> getPosts(){
        return blogPostService.getBlogPostList();
    }

    @GetMapping("/{bloPostId}")
    public BlogPost findyById(@PathVariable int blogPostId){
        return blogPostService.findPostById(blogPostId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createBloPost(@RequestBody BlogPost body){
        blogPostService.saveBlogPost(body);
        return "BLOG POST CREATED!";
    }

    @PutMapping("/{bloPostId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String editBlogPost(@PathVariable int blogPostId, @RequestBody BlogPost body){
        blogPostService.updateBlogPost(blogPostId,body);
        return "BLOG POST EDITED";
    }

    @DeleteMapping("/{blogPostId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteBlogPost(@PathVariable int blogPostId){
        blogPostService.findyByIdAndDelete(blogPostId);
        return "BLOG POST DELETED CORRECTLY";
    }
}
