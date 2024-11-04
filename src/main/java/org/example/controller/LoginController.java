package org.example.controller;

import org.example.exceptions.NotFoundException;
import org.example.service.login.LoginService;
import org.example.service.login.LoginServiceFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginController {
    private final LoginService loginService = LoginServiceFactory.create();

    @GET
    @Path("/{login}/{senha}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkUser(@PathParam("login") String login, @PathParam("senha") String senha){
        try {
            return Response.status(Response.Status.OK)
                    .entity(this.loginService.checkLogin(login, senha))
                    .build();
        } catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


}
