package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import Service.UserService;
import io.swagger.v3.oas.annotations.Parameter;

import model.Users;

import java.net.URISyntaxException;
import java.util.Optional;

    @Path("/user")
    @Produces({"application/json"})
    public class UserRest {
        UserService userService = new UserService();

        @GET
        @Path("/{Id}")
        public Optional<Users> getPetById(@PathParam("Id") Long userId)  {
            return userService.getUser(userId);
        }

    @GET
    @Path("/email/{userEmail}")
    @Produces({MediaType.APPLICATION_JSON})
    public Iterable<Users> getUserByEmail(@PathParam("userEmail") String userEmail) throws URISyntaxException {
        return userService.getUsersByEmail(userEmail);
    }

    @GET
    @Path("/firstname/{userName}")
    @Produces({"application/json"})
    public Iterable<Users> getUserByName(@PathParam("userName") String userName) throws URISyntaxException {
        return userService.getUsersByName(userName);
    }

    @GET
    @Path("/lastname/{userLastname}")
    @Produces({"application/json"})
    public Iterable<Users> getUserByLastname(@PathParam("userLastname") String userLastname) throws URISyntaxException {
        return userService.getUsersByLastname(userLastname);
    }

    @GET
    @Path("/all")
    @Produces({"application/json"})
    public Iterable<Users> getAllUsers() throws URISyntaxException {
        return userService.getUsers();
    }


    @GET
    @Path("/profs")
    @Produces({"application/json"})
    public Iterable<Users> getAllProfs() throws URISyntaxException {
        return userService.getProfs();
    }

    @GET
    @Path("/clients")
    @Produces({"application/json"})
    public Iterable<Users> getClients() throws URISyntaxException {
        return userService.getClients();
    }

    @POST
    @Path("/user{user}")
    public Users addUser(Users user) {

        return userService.saveUser(user);
    }

    /**
     *  modify a user
     * @param id
     * @param user
     * @return
     */
   @PUT
    @Path("/user/{rdvId}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Users modifyRdv(@PathParam("rdvId") Long id, Users user) {
        return userService.modifyUser(id, user);
    }

    @Path("/{userId}/delete")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response deleteUser(@PathParam("userId") Long userId) throws URISyntaxException {
        userService.deleteUser(userId);
        return Response.status(202).entity("User deleted successfully !!").build();
    }
}
