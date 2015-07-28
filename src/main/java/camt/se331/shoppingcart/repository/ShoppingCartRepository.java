package camt.se331.shoppingcart.repository;

import camt.se331.shoppingcart.entity.ShoppingCart;
import camt.se331.shoppingcart.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Dto on 4/6/2015.
 */
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {
    List<ShoppingCart> findByUser(User user);
}
