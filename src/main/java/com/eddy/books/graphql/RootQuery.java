package com.eddy.books.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.eddy.books.model.Author;
import com.eddy.books.model.Book;
import com.eddy.books.repository.AuthorRepository;
import com.eddy.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RootQuery implements GraphQLQueryResolver {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Autowired
    public RootQuery(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countAuthors() {
        return authorRepository.count();
    }
}
