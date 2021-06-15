package guru.springframework.spring5webapp.repsitories;

import guru.springframework.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRespitory extends CrudRepository<Book,Long> {
}
