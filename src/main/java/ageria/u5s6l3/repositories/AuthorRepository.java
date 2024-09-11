package ageria.u5s6l3.repositories;


import ageria.u5s6l3.entities.Author;
import ageria.u5s6l3.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {



}
