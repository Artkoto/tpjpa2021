package rest;

import Service.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import model.Users;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/users")
@Produces({"application/json"})
public class UserRest {
    UserService userService = new UserService();
//    @GET
//    @Path("/{userId}")
//    public Optional<Users> getUserById(@PathParam("userId") Long userId)  {
//        // return User
//        return userService.getUser(userId);
//    }

    //    @GET
//    @Path("/{userEmail}")
//    public Optional<Users> getUserByEmail(@PathParam("userEmail") Long userEmail)  {
//        return userService.getByEmail(userEmail);
//    }
    @GET
    @Path("/{userName}")
    public Iterable<Users> getUserByName(@PathParam("userName") String userName)  {
        return userService.getUsersByName(userName);
    }

    @GET
    @Path("/{userLastname}")
    public Iterable<Users> getUserByLastname(@PathParam("userLastname") String userLastname)  {
        return userService.getUsersByLastname(userLastname);
    }

    @GET
    @Path("/")
    public Iterable<Users> getAllUsers()  {
        return userService.getUsers();
    }

    @GET
    @Path("/profs")
    public Iterable<Users> getAllProfs()  {
        return userService.getProfs();
    }


    @GET
    @Path("/clients")
    public Iterable<Users> getClients()  {
        return userService.getClients();
    }

    @POST
    @Consumes("application/json")
    public Response addPet(
            @Parameter(description = "Pet object ", required = true) Users pet) {
        // add pet
        return Response.ok().entity("SUCCESS").build();
    }
}
