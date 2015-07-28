package camt.se331.shoppingcart.service;

import camt.se331.shoppingcart.dao.DbUserDao;
import camt.se331.shoppingcart.entity.ShoppingCart;
import camt.se331.shoppingcart.entity.User;
import camt.se331.shoppingcart.repository.ShoppingCartRepository;
import camt.se331.shoppingcart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

/**
 * Created by Dto on 4/19/2015.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    ShoppingCartRepository shoppingCartRepository;
    @Autowired
    DbUserDao dbUserDao;


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findUserByEmail(String username) {
        return null;
    }

    @Override
    public User login(String email, String password) {
        return null;
    }

    @Override
    @Transactional
    public ShoppingCart addShoppingCart(User user, ShoppingCart shoppingCart) {
        User currentUser = userRepository.findOne(user.getId());
                currentUser.getShoppingCarts().add(shoppingCart);
                shoppingCart.setUser(currentUser);
                shoppingCartRepository.save(shoppingCart);
        return shoppingCart;
         }
    @Override
    public List<ShoppingCart> getShoppingCart(User user) {
        User currentUser = userRepository.findOne(user.getId());
        return shoppingCartRepository.findByUser(currentUser);
    }

    @Override
    public List<User> getUser() {
        return dbUserDao.getUser();
    }

    @Override
    public User getUser(Long id) {
        return dbUserDao.getUser(id);
    }

    @Override
    public User addUser(User user) {
        return dbUserDao.addUser(user);
    }

    @Override
    public User deleteUser(Long id) {
        User user = getUser(id);
        return dbUserDao.deleteUser(user);
    }

    @Override
    public User updateUser(User user) {
        return dbUserDao.updateUser(user);
    }

    @Override
    public List<User> getUserByName(String name) {
        return dbUserDao.getUserByName(name);
    }

}
