package rest;

import Service.CreneauService;
import Service.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import model.Creneau;
import model.Users;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.Optional;

@Path("/slots")
@Produces({"application/json", "application/xml"})
public class CreneauRest {
    CreneauService creneauService = new CreneauService();

    /**
     *  get crenel by Id
     * @param creneauId
     * @return
     */
    @GET
    @Path("/{Id}")
    @Produces({"application/json"})
    public Optional<Creneau> getCreneau(@PathParam("Id") Long creneauId) {
        return creneauService.getCreneau(creneauId);
    }

    /**
     * get all slots
     * @return
     */
    @GET
    @Path("/all")
    @Produces({"application/json"})
    public Iterable<Creneau> getAllCreneaux() {
        return creneauService.getCreneaux();
    }

    @POST
    @Path("/{creneau}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Creneau addCreneau( Creneau creneau) throws URISyntaxException {
        return creneauService.saveCreneau(creneau);
    }

    @PATCH
    @Path("/{creneauId}/creneau/{creneau}/")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Creneau modifyCreneau(@PathParam("creneauId") Long id, Creneau creneau) {
        return creneauService.modifyCreneau(id, creneau);
    }

}
