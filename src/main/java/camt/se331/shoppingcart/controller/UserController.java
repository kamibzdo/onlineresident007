package camt.se331.shoppingcart.controller;

import camt.se331.shoppingcart.entity.User;
import camt.se331.shoppingcart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 26/7/2558.
 */
@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public List<User> list() {
        return userService.getUser();
    }


    @RequestMapping(value = "getUser", method = RequestMethod.GET)
    public List<User> getListByName(@RequestParam("name") String name) {
        return userService.getUserByName(name);
    }

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public
    @ResponseBody
    User add(@RequestBody User user, BindingResult bindingResult) {
        return userService.addUser(user);
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public User getProduct(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.PUT)
    public User edit(@PathVariable("id") Long id, @RequestBody User user, BindingResult bindingResult) {
        return userService.updateUser(user);
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public User edit(@PathVariable("id") Long id) {
        return userService.deleteUser(id);
    }
}
