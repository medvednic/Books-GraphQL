package com.eddy.books.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.eddy.books.model.Book;
import com.eddy.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMutationResolver implements GraphQLMutationResolver {
    private BookRepository bookRepository;

    @Autowired
    public BookMutationResolver(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book bookToAdd){
        return bookRepository.save(bookToAdd);
    }
}
