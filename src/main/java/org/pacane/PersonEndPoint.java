package org.pacane;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/people")
@Produces(MediaType.APPLICATION_JSON)
public class PersonEndPoint {
    private final PersonService service;
    private final PersonConverter personConverter;

    @Inject
    PersonEndPoint(PersonService service, PersonConverter personConverter) {
        this.service = service;
        this.personConverter = personConverter;
    }

    @GET
    @Path("/last")
    public Response getLastPerson() {
        Person lastPersonAdded = service.getLastPersonAdded();

        if (lastPersonAdded == null) {
            return Response.status(404).build();
        }

        String jsonPerson = personConverter.toJson(lastPersonAdded);

        return Response.status(200).entity(jsonPerson).build();
    }
}