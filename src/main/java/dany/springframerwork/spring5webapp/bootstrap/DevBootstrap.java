package dany.springframerwork.spring5webapp.bootstrap;

import dany.springframerwork.spring5webapp.model.Author;
import dany.springframerwork.spring5webapp.model.Book;
import dany.springframerwork.spring5webapp.model.Publisher;
import dany.springframerwork.spring5webapp.repositories.AuthorRepository;
import dany.springframerwork.spring5webapp.repositories.BookRepository;
import dany.springframerwork.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initData(){

        //Eric
        Author eric =  new Author("Eric", "Evans");
        Publisher harperCollins = new Publisher("Harper_Collins", "1234567");
        Book ddd = new Book("Domain Drivern Design", "1234", harperCollins);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(harperCollins);
        bookRepository.save(ddd);


        //Rod
        Author rod =  new Author("Rod", "Jhonson");
        Publisher worx = new Publisher("worx", "1224 Philli Lane");
        Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        authorRepository.save(rod);
        publisherRepository.save(worx);
        bookRepository.save(noEJB);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
