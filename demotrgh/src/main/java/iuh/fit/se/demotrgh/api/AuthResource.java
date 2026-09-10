package iuh.fit.se.demotrgh.api;

import iuh.fit.se.demotrgh.model.LoginRequest;
import iuh.fit.se.demotrgh.service.AuthenticationScope;
import iuh.fit.se.demotrgh.service.UserSession;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Map;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class AuthResource {

    @Inject
    private AuthenticationScope authenticationScope;
    @Inject
    private UserSession userSession;

    @POST
    @Path("/login")
    public Response authenticate(LoginRequest request) {
        boolean isValid = authenticationScope.authenticate(request.getUsername(), request.getPassword());
        if (!isValid) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Invalid")
                    .build();
        } else {
            userSession.login(request.getUsername());
            return Response.ok("Success").build();
        }
    }

    @GET
    @Path("/session")
    public Map<String, Object> session() {
        return Map.of(
                "loggedIn", userSession.isAuthenticate(),
                "username",
                userSession.getUsername() == null
                        ? ""
                        : userSession.getUsername(),
                "instanceId",
                userSession.getInstanceId()
        );
    }

    @DELETE
    @Path("/logout")
    public Response logout(@Context HttpServletRequest request) {
        if (request.getSession(false) != null) {
            request.getSession(false).invalidate();
        }

        return Response.noContent().build();

    }

}
