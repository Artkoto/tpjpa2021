package rest;

import Service.RdvService;
import model.Rdv;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/rdv")
@Produces({"application/json"})
public class RdvRest {
    RdvService rdvService = new RdvService();

    /**
     * get appointment by ID
     * @param Id : id of the appointment
     * @return
     */
    @GET
    @Path("/id={Id}")
    public Rdv getRdvById(@PathParam("Id") Long Id)  {
        return rdvService.getRdv(Id).get();
    }

    /**
     * get all appointments
     * @return
     */
    @GET
    @Path("/all")
    public Iterable<Rdv> getAllRdvs() {
        return rdvService.getRdvs();
    }

    /**
     *  get appointment by title
     * @param title : title of the appointment
     * @return
     */
    @GET
    @Path("/title={title}")
    public Iterable<Rdv> getRdvByTitle(@PathParam("title") String title)  {
        return rdvService.getRdvByTitle(title);
    }

    /**
     *  add appointment
     * @param rdv : appointment
     * @return
     */
    @POST
    @Path("/add")
    @Consumes({"application/json"})
    public Rdv addRdv(Rdv rdv) {
        return rdvService.saveRdv(rdv);

    }

    /**
     *  modify an appointment
     * @param id
     * @param rdv
     * @return
     */
    @PUT
    @Path("/{rdvId}/update")
    @Consumes({"application/json"})
    public Rdv modifyRdv( @PathParam("rdvId") Long id, Rdv rdv) {
        return rdvService.modifyRdv(id, rdv);
    }

    /***
     *  delete appointment
     * @param rdvId : id of the appointment
     * @return
     */
    @DELETE
    @Path("/{Id}/delete")
    @Consumes({"application/json"})
    public Response deleteRdv(@PathParam("Id") Long rdvId) {
         rdvService.deleteRdv(rdvId);
        return Response.status(202).entity("Rdv deleted successfully !!").build();
    }
}
