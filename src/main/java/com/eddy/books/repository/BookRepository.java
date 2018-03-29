package com.eddy.books.repository;

import com.eddy.books.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    Iterable<Book> findAllByAuthorId(Long authorId);
}
