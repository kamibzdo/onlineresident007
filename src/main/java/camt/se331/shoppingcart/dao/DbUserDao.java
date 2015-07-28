package camt.se331.shoppingcart.dao;

import camt.se331.shoppingcart.entity.User;
import camt.se331.shoppingcart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 26/7/2558.
 */
@Repository
public class DbUserDao implements UserDao {
    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUserByName(String name) {
        return null;
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(User user) {
         userRepository.delete(user);
        user.setId(null);
        return user;

    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
