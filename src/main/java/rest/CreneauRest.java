package rest;

import Service.CreneauService;

import model.Creneau;
import javax.ws.rs.*;


@Path("/slot")
@Produces({"application/json"})
public class CreneauRest {
    CreneauService creneauService = new CreneauService();

    /**
     *  get crenel by Id
     * @param creneauId
     * @return
     */
    @GET
    @Path("/id={Id}")
    public Creneau getCreneau(@PathParam("Id") Long creneauId) {
        return creneauService.getCreneau(creneauId).get();
    }

    /**
     * get all slots
     * @return
     */
    @GET
    @Path("/all")
    public Iterable<Creneau> getAllCreneaux() {
        return creneauService.getCreneaux();
    }

    @POST
    @Path("/add")
    @Consumes({"application/json"})
    public Creneau addCreneau( Creneau creneau)  {
        return creneauService.saveCreneau(creneau);
    }

    @PUT
    @Path("/{creneauId}/update")
    @Consumes({"application/json"})
    public Creneau modifyCreneau(@PathParam("creneauId") Long id, Creneau creneau) {
        return creneauService.modifyCreneau(id, creneau);
    }

}
