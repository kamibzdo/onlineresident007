package camt.se331.shoppingcart.dao;


import camt.se331.shoppingcart.entity.User;

import java.util.List;

/**
 * Created by Administrator on 26/7/2558.
 */
public interface UserDao {
    List<User> getUser();
    List<User> getUserByName(String name);
    User getUser(Long id);
    User addUser(User user);
    User deleteUser(User user);
    User updateUser(User user);
}
