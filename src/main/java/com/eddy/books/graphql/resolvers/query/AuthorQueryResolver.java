package com.eddy.books.graphql.resolvers.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.eddy.books.model.Author;
import com.eddy.books.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorQueryResolver implements GraphQLQueryResolver {
    private AuthorRepository authorRepository;

    @Autowired
    public AuthorQueryResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countAuthors() {
        return authorRepository.count();
    }
}
