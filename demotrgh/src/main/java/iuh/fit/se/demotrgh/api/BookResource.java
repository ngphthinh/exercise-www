package iuh.fit.se.demotrgh.api;

import iuh.fit.se.demotrgh.model.Book;
import iuh.fit.se.demotrgh.service.BookService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/books")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class BookResource {

    @Inject
    private BookService bookService;


    @GET
    public Response getAllBook() {
        return Response.ok(bookService.getAllBook()).build();
    }

    @POST
    public Response create(Book book) {
        bookService.createBook(book);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        bookService.delete(id);
        return Response.noContent().build();
    }


    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") String id, Book book) {
        book.setId(id);
        bookService.update(id, book);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") String id) {
        return Response.ok(bookService.findById(id)).build();
    }

    @GET
    @Path("/search")
    public Response search(@QueryParam("keyword") String keyword){
        return Response.ok(bookService.search(keyword)).build();
    }
}
