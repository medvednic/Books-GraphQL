package com.eddy.books.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.eddy.books.model.Author;
import com.eddy.books.model.Book;
import com.eddy.books.repository.AuthorRepository;
import com.eddy.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Autowired
    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public Author addAuthor(String firstName, String lastName){
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        return authorRepository.save(author);
    }

    public Book addBook(Book bookToAdd){
        return bookRepository.save(bookToAdd);
    }
}
