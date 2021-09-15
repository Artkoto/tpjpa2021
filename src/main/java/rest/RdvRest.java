package rest;

import io.swagger.v3.oas.annotations.Parameter;
import model.Rdv;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/pet")
@Produces({"application/json", "application/xml"})
public class RdvRest {
    @GET
    @Path("/{petId}")
    public Rdv getPetById(@PathParam("petId") Long petId)  {
        // return pet
        return new Rdv();
    }

    @POST
    @Consumes("application/json")
    public Response addPet(
            @Parameter(description = "Pet object ", required = true) Rdv pet) {
        // add pet
        return Response.ok().entity("SUCCESS").build();
    }
}
