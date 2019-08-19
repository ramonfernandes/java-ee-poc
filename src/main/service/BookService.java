package service;

import model.Book;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Stateless
@Path("book")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
public class BookService {

    @PersistenceContext
    private EntityManager entityManager;

    @GET
    public String getAll() {
        return "funciona";
    }

    @POST
    public void createBook(Book book){
        entityManager.persist(book);
    }

    @PUT
    public Book updateBook(Book book) {
        return entityManager.merge(book);
    }

    @DELETE
    @Path("/{id}")
    public void deleteBook (@PathParam("id") Long bookId) {
        Book book = entityManager.find(Book.class, bookId);
        entityManager.remove(book);
    }
}
