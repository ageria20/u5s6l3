package ageria.u5s6l3.repositories;

import ageria.u5s6l3.entities.Author;
import ageria.u5s6l3.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BlogPostRepository extends JpaRepository<BlogPost, UUID> {
}
