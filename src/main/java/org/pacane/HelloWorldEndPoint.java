package org.pacane;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
@Produces(MediaType.TEXT_PLAIN)
public class HelloWorldEndPoint {
    private final PersonService service;

    @Inject
    HelloWorldEndPoint(PersonService service) {
        this.service = service;
    }

    @GET
    public Response printMessage() {
        Person lastPersonAdded = service.getLastPersonAdded();
        String result = "Hello !" + lastPersonAdded.name;
        return Response.status(200).entity(result).build();
    }
}