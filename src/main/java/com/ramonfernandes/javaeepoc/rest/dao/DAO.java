package com.ramonfernandes.javaeepoc.rest.dao;

import com.ramonfernandes.javaeepoc.rest.dto.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO {

    public List<Book> get() throws SQLException {
        Connection conn = new ConnectionSetup().getConn();

        String queryString = "select * from Book";
        Statement stmt = conn.createStatement();
        ResultSet rset = stmt.executeQuery(queryString);

        List<Book> result = new ArrayList<>();

        while (rset.next()) {
            result.add(new Book(rset.getInt(1), rset.getString(2)));
        }

        return result;

    }

    public void delete(int id) throws SQLException {

        Connection conn = new ConnectionSetup().getConn();

        String queryString = "delete from Book where id=" + id;
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(queryString);

    }

    public void update(int id, Book book) throws SQLException {
        Connection conn = new ConnectionSetup().getConn();

        String queryString = "UPDATE Book" +
                " SET id = "+book.getId()+", name= '"+book.getName()+"' " +
                "WHERE id = "+id+";";
        System.out.println(queryString);
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(queryString);
    }

    public void create(Book book) throws SQLException {
        Connection conn = new ConnectionSetup().getConn();

        String queryString = "INSERT INTO Book " + "VALUES (" + book.getId() + ", '" + book.getName() + "')";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(queryString);
    }

}
