package com.ramonfernandes.javaeepoc.rest.dao;

import com.ramonfernandes.javaeepoc.rest.dto.Book;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;

public class DAO {

    private static EntityManagerFactory factory;
    private static EntityManager entityManager;

    @Transactional
    public Collection<Book> get() throws SQLException {

        Query query = entityManager.createQuery("SELECT x FROM Book x");
        Collection<Book> books = (Collection<Book>) query.getResultList();

        return books;
    }

    @Transactional
    public void delete(int id) throws SQLException {

        Book book = entityManager.find(Book.class, id);

        entityManager.getTransaction().begin();
        entityManager.remove(book);
        entityManager.getTransaction().commit();


    }

    @Transactional
    public void update(int id, Book book) throws SQLException {

        Book newBook = entityManager.find(Book.class, id);

        entityManager.getTransaction().begin();
        newBook.setName(book.getName());
        entityManager.getTransaction().commit();
    }

    @Transactional
    public void create(Book book) throws SQLException {

        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();

    }

}
