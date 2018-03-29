package com.eddy.books.graphql.resolvers.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.eddy.books.model.Book;
import com.eddy.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookQueryResolver implements GraphQLQueryResolver {

    private BookRepository bookRepository;

    @Autowired
    public BookQueryResolver(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }

    public Iterable<Book> findBooksByAuthor(Long authorId){
        return bookRepository.findAllByAuthorId(authorId);
    }
}
