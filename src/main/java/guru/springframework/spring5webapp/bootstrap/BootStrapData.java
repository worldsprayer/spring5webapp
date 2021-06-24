package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repsitories.AuthorRepository;
import guru.springframework.spring5webapp.repsitories.BookRepository;
import guru.springframework.spring5webapp.repsitories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");


        Publisher clearing = new Publisher("Clearing House", "123 main", "Austin", "TX", "11111");
        publisherRepository.save(clearing);
        System.out.println("Number of Publishers: " + publisherRepository.count());

        Author eric = new Author("Eric","Blah");
        Book ddd = new Book("Domain Driven Design","123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(clearing);
        clearing.getBooks().add(ddd);
        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(clearing);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2ee","123124");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(clearing);
        clearing.getBooks().add(noEJB);


        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(clearing);


        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers " + publisherRepository.count());
        System.out.println("Number of publisher books: " + clearing.getBooks().size());
    }
}
