package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import Service.UserService;

import model.Client;
import model.Prof;
import model.Users;

import java.net.URISyntaxException;

    @Path("/user")
    @Produces({"application/json"})
    public class UserRest {
        UserService userService = new UserService();

        @GET
        @Path("id={Id}")
        public Users getPetById(@PathParam("Id") Long userId)  {
                return userService.getUser(userId).get();
            }

        @GET
        @Path("email={userEmail}")
        public Iterable<Users> getUserByEmail(@PathParam("userEmail") String userEmail)  {
            return userService.getUsersByEmail(userEmail);
        }

        @GET
        @Path("/firstname={userName}")
        public Iterable<Users> getUserByName(@PathParam("userName") String userName)  {
            return userService.getUsersByName(userName);
        }

        @GET
        @Path("/lastname={userLastname}")
        public Iterable<Users> getUserByLastname(@PathParam("userLastname") String userLastname){
            return userService.getUsersByLastname(userLastname);
        }

        @GET
        @Path("/all")
        public Iterable<Users> getAllUsers() throws URISyntaxException {
            return userService.getUsers();
        }


        @GET
        @Path("/profs")
        public Iterable<Users> getAllProfs() throws URISyntaxException {
            return userService.getProfs();
        }

        @GET
        @Path("/clients")
        public Iterable<Users> getClients() throws URISyntaxException {
            return userService.getClients();
        }

        @POST
        @Path("/client/add")
        @Consumes({"application/json"})
        public Users addClient(Client user) {
            return userService.saveUser(user);
        }
        @POST
        @Path("/prof/add")
        @Consumes({"application/json"})
        public Users addProf(Prof user) {
            return userService.saveUser(user);
        }

        /**
         *  modify a user
         * @param id
         * @param user
         * @return
         */
       @PUT
        @Path("/prof/{userId}/update")
        @Consumes({"application/json"})
        public Users modifyProf(@PathParam("userId") Long id, Prof  user) {
            return userService.modifyUser(id, user);
        }

        @PUT
        @Path("/client/{userId}/update")
        @Consumes({"application/json"})
        public Users modifyClient(@PathParam("userId") Long id, Client  user) {
            return userService.modifyUser(id, user);
        }



        @Path("/{userId}/delete")
        @DELETE
        public Response deleteUser(@PathParam("userId") Long userId) throws URISyntaxException {
            userService.deleteUser(userId);
            return Response.status(202).entity("User deleted successfully !!").build();
        }
}
