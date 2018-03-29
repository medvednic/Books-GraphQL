package com.eddy.books.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.eddy.books.graphql.exceptions.BookNotFoundException;
import com.eddy.books.model.Author;
import com.eddy.books.model.Book;
import com.eddy.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public boolean deleteBook (Long bookId) {
        Book bookToDelete = bookRepository.findById(bookId).orElse(null);
        if (null == bookToDelete) {
            throw new BookNotFoundException("The book to delete wasn't found", bookId);
        }
        bookRepository.deleteById(bookId);
        return true;
    }

    public Book addCoAuthors(Long bookId, List<Long> coAuthors){
        Book bookToModify = bookRepository.findById(bookId).orElse(null);
        if (null == bookToModify){
            throw new BookNotFoundException("The book to update wasn't found", bookId);
        }

        coAuthors.forEach(c -> bookToModify.getCoAuthors().add(new Author(c)));
        return bookRepository.save(bookToModify);
    }
}
