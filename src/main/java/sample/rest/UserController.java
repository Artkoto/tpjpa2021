package sample.rest;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sample.service.UserService;
import sample.domain.Client;
import sample.domain.Prof;
import sample.domain.User;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

@RestController
@RequestMapping("/user")
public class UserController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @GetMapping("/get-by-id/{userId}")
	@ResponseBody
    public User getPetById(@PathVariable Long userId)  {
            return userService.getUser(userId).get();
    }

    @GetMapping("/get-by-email/{userEmail}")
    @ResponseBody
    public User getUserByEmail(@PathVariable String userEmail)  {
        return userService.getUsersByEmail(userEmail);
    }

	@GetMapping("/get-by-name/{userName}")
	@ResponseBody
    public User getUserByName(@PathVariable String userName)  {
        return userService.getUsersByName(userName);
    }

	@GetMapping("/get-by-lastname/{userLastname}")
	@ResponseBody
    public User getUserByLastname(@PathVariable String userLastname){
        return userService.getUsersByLastname(userLastname);
    }

	@GetMapping("/users")
	@ResponseBody
    public Iterable<User> getAllUsers() {
        return userService.getUsers();
    }

	@PostMapping("/create-client")
	@ResponseBody
    public User addClient(Client client) {
        return userService.saveUser(client);
    }

	@PostMapping("/create-prof")
	@ResponseBody
    public User addProf(Prof prof) {
        return userService.saveUser(prof);
    }

    /**
     *  modify a user
     * @param id
     * @param user
     * @return
     */
	@PutMapping("/update/prof")
	@ResponseBody
    public User modifyProf(Prof  user) {
        return userService.updateUser(user);
    }

	@PutMapping("/update/client")
	@ResponseBody
    public User modifyClient(User  user) {
        return userService.updateUser(user);
    }

	@DeleteMapping("/delete/{userId}")
	@ResponseBody
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }   

}
