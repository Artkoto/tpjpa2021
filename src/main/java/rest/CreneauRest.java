package rest;

import io.swagger.v3.oas.annotations.Parameter;
import model.Creneau;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/pet")
@Produces({"application/json", "application/xml"})
public class CreneauRest {
    @GET
    @Path("/{petId}")
    public Creneau getPetById(@PathParam("petId") Long petId)  {
        // return pet
        return new Creneau();
    }

    @POST
    @Consumes("application/json")
    public Response addPet(
            @Parameter(description = "Pet object ", required = true) Creneau pet) {
        // add pet
        return Response.ok().entity("SUCCESS").build();
    }
}
