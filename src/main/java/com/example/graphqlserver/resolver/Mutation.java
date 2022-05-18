package com.example.graphqlserver.resolver;

import org.apache.commons.lang3.StringUtils;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.graphqlserver.model.Author;
import com.example.graphqlserver.model.Book;
import com.example.graphqlserver.repository.AuthorRepository;
import com.example.graphqlserver.repository.BookRepository;

public class Mutation implements GraphQLMutationResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    // Create
    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.save(author);

        return author;
    }

    public Book newBook(Long id, String title, String isbn, Integer pageCount, Long authorId) {
        Book book = new Book();
        book.setId(id);
        book.setAuthor(new Author(authorId));
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);

        bookRepository.save(book);

        return book;
    }

    // Update
    public Book updateBookPageCount(Integer pageCount, Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if(book == null) {
            throw new BookNotFoundException("The book to be updated was not found", id);
        }
        book.setPageCount(pageCount);

        bookRepository.save(book);

        return book;
    }
    
    public Book updateBook(Long id, String title, String isbn, Integer pageCount, Long authorId) {
        Book book = bookRepository.findById(id).orElse(null);
        if(book == null) {
            throw new BookNotFoundException("The book to be updated was not found", id);
        }
        book.setTitle(title);
        if (isbn != null) {
        	book.setIsbn(isbn);
        }
        if (pageCount != null) {
        	book.setPageCount(pageCount);
        }
        if (authorId != null) {
        	Author author = authorRepository.findById(authorId).orElse(null);
        	if (author != null) {
        		book.setAuthor(author);
        	}
        }

        bookRepository.save(book);

        return book;
    }

    // Delete
    public boolean deleteBook(Long id) {
        bookRepository.deleteById(id);
        return true;
    }
}