/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.spring1.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Fernando
 */
@Entity 
@Table (name="tb_book"/*, schema="test_project"*/)
public class Book implements Serializable{

    private static final long serialVersionUID = -1313921026471428376L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_book")
    private int idBook;
    
    @Column(name="title")
    private String title;
    
    @Column(name="isbn")
    private String isbn;
    
    @Column(name="publisher")
    private String publisher;
    
    @ManyToMany
    @JoinTable(name = "tb_author_book"/*, schema ="test_project"*/,
            joinColumns = @JoinColumn(name="id_book"), inverseJoinColumns=@JoinColumn(name="id_author"))
    private Set<Author> authors = new HashSet<>();

    public Book() {
    }

    public Book(int idBook, String title, String isbn, String publisher) {
        this.idBook = idBook;
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
    }
    
    public Book(int idBook, String title, String isbn, String publisher, Set<Author> authors) {
        this.idBook = idBook;
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.authors = authors;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" + "idBook=" + idBook + ", title=" + title + ", isbn=" + isbn + ", publisher=" + publisher + ", authors=" + authors + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idBook;
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
        final Book other = (Book) obj;
        if (this.idBook != other.idBook) {
            return false;
        }
        return true;
    }

    
}
