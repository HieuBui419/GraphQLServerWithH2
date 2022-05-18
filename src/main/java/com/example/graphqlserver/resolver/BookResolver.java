package com.example.graphqlserver.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.graphqlserver.model.Author;
import com.example.graphqlserver.model.Book;
import com.example.graphqlserver.repository.AuthorRepository;

// GraphQLResolver<T> is one in four types of Resolver class, which is responsible for resolving complex types (classes)
public class BookResolver implements GraphQLResolver<Book> {
    private AuthorRepository authorRepository;

    public BookResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author getAuthor(Book book) {
        return authorRepository.findById(book.getAuthor().getId()).orElse(null);
    }
}