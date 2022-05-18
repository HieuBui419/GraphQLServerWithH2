package com.example.graphqlserver.model;

import javax.persistence.*;

/**
 * Reference: https://www.vogella.com/tutorials/JavaPersistenceAPI/article.html
 * Mapping Java objects to database tables and vice versa is called Object-Relational Mapping (ORM).
 * The Java Persistence API (JPA) is one approach to ORM. With JPA, developers can map, store, update
 * and retrieve data from relational db to Java objects and vice versa.
 */
@Entity
public class Author {
    @Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "author_id", unique = true, nullable = false)
    private Long id;

    private String firstName;

    private String lastName;

    public Author() {
    }

    public Author(Long id) {
        this.id = id;
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return id.equals(author.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
