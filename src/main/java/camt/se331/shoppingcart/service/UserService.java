package camt.se331.shoppingcart.service;

import camt.se331.shoppingcart.entity.ShoppingCart;
import camt.se331.shoppingcart.entity.User;

import java.util.List;

/**
 * Created by Dto on 4/19/2015.
 */
public interface UserService {
    public List<User> findAll();
    public User findByUserName(String username);
    public User findUserByEmail(String username);
    public User login(String email, String password);
    public ShoppingCart addShoppingCart(User user, ShoppingCart shoppingCart);
    public List<ShoppingCart> getShoppingCart(User user);
    List<User> getUser();
    User getUser(Long id);
    User addUser(User user);
    User deleteUser(Long id);
    User updateUser(User user);
    List<User> getUserByName(String name);
}
