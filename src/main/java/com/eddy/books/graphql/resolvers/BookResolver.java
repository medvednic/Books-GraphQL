package com.eddy.books.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.eddy.books.model.Author;
import com.eddy.books.model.Book;
import com.eddy.books.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BookResolver implements GraphQLResolver<Book> {
    private AuthorRepository authorRepository;

    @Autowired
    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book){
        Optional<Author> authorOpt = authorRepository.findById(book.getAuthor().getId());
        return authorOpt.orElse(null);
    }

    public Iterable<Author> getCoAuthors(Book book){
        List<Long> coAuthors = book.getCoAuthors().stream().map(Author::getId).collect(Collectors.toList());
        return authorRepository.findAllById(coAuthors);
    }
}
