package dany.springframerwork.spring5webapp.repositories;

import dany.springframerwork.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
