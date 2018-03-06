/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.spring1.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Fernando
 */
@Entity
@Table (name="tb_author"/*, schema="test_project"*/)
public class Author implements Serializable{

    private static final long serialVersionUID = 3783093145423408126L;
        
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_author")
    private int idAuthor;
    
    @Column(name="first_name")
    private String firstName;
    
    @Column(name="last_name")
    private String lastName;
    
    @ManyToMany (mappedBy="authors")
    private Set<Book> books = new HashSet<>();

    public Author() {
    }

    public Author(int idAuthor, String firstName, String lastName) {
        this.idAuthor = idAuthor;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public Author(int idAuthor, String firstName, String lastName, Set<Book> books) {
        this.idAuthor = idAuthor;
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idAuthor;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Author other = (Author) obj;
        if (this.idAuthor != other.idAuthor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Author{" + "idAuthor=" + idAuthor + ", firstName=" + firstName + ", lastName=" + lastName + ", books=" + books + '}';
    }
}
