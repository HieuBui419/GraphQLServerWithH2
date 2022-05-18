package com.example.graphqlserver.repository;

import com.example.graphqlserver.model.Author;

import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    // Methods: Create, Read, Update and Delete
}
