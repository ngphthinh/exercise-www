package iuh.fit.se.demotrgh.api;

import iuh.fit.se.demotrgh.model.CartItem;
import iuh.fit.se.demotrgh.service.UserSession;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/cart")
public class CartResource {
    @Inject
    private UserSession userSession;


    @GET
    public Response getCart() {
        return Response.ok(userSession.getCart().getBookList()).build();
    }

    @POST
    public Response addCart(CartItem item) {
        userSession.getCart().addToCard(item);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response remove(@PathParam("id") String id) {
        userSession.getCart().remove(id);
        return Response.ok().build();
    }

    @DELETE
    @Path("/clear")
    public Response clear() {
        userSession.getCart().clear();
        return Response.ok().build();
    }

}
