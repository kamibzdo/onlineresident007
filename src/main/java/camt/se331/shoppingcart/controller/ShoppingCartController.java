package camt.se331.shoppingcart.controller;

import camt.se331.shoppingcart.config.security.SecurityUser;
import camt.se331.shoppingcart.entity.Product;
import camt.se331.shoppingcart.entity.SelectedProduct;
import camt.se331.shoppingcart.entity.ShoppingCart;
import camt.se331.shoppingcart.service.ShoppingCartService;
import camt.se331.shoppingcart.service.UserService;
import com.sun.tracing.dtrace.ModuleAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Dto on 4/6/2015.
 */
@RestController
@RequestMapping("/shoppingcart")
@SessionAttributes({"currentShoppingCart"})
public class ShoppingCartController {
    @Autowired
    UserService userService;
    @Autowired
    ShoppingCartService shoppingCartService;
    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public ShoppingCart getShoppingCart(@PathVariable("id") Long id){
        return shoppingCartService.findById(id);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public ShoppingCart updateShoppingCart(@PathVariable("id")Long id,@RequestBody ShoppingCart cart, BindingResult bindingResult){
        return shoppingCartService.addShoppingCart(cart);
    }
    @ModelAttribute("currentShoppingCart")
    public ShoppingCart getCurrentShoppingCart(){
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setPurchaseDate(Calendar.getInstance().getTime());
        return shoppingCart;
    }
    @RequestMapping(value = "/addToCart",method = RequestMethod.POST)
    public ShoppingCart addProduct(@ModelAttribute("currentShoppingCart")ShoppingCart shoppingCart,@RequestBody Product product,BindingResult bindingResult,Model model){
        return  shoppingCartService.addSelectedProduct(shoppingCart,product);
    }
     @RequestMapping(value="/updateCart",method = RequestMethod.POST)
     public ShoppingCart updateCart(@RequestBody ShoppingCart shoppingCart, BindingResult bindingResult,Model model){
         shoppingCart.setPurchaseDate(Calendar.getInstance().getTime());
        model.addAttribute("currentShoppingCart",shoppingCart);
        return shoppingCart;
     }
    @RequestMapping(value="/removeProduct",method = RequestMethod.POST)
     public ShoppingCart removeProduct(@ModelAttribute("currentShoppingCart") ShoppingCart shoppingCart,@RequestBody Product product, BindingResult bindingResult,Model model){
         SelectedProduct toRemove = null;
         for(SelectedProduct
                selectedProduct:shoppingCart.getSelectedProducts()){
             if (selectedProduct.getProduct().equals(product)){
                 toRemove = selectedProduct;
                 break;
                 }
             }
         shoppingCart.getSelectedProducts().remove(toRemove);
         return shoppingCart;
         }
    @RequestMapping(value="/saveCart",method = RequestMethod.POST)
    public ShoppingCart saveCart(@RequestBody ShoppingCart shoppingCart){
        shoppingCart.setPurchaseDate(Calendar.getInstance().getTime());
        SecurityUser securityUser = (SecurityUser)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        shoppingCart = userService.addShoppingCart(securityUser,
                shoppingCart);
        return shoppingCart;
    }
    @RequestMapping(method = RequestMethod.GET)
    public ShoppingCart getCart(@ModelAttribute("currentShoppingCart") ShoppingCart shoppingCart,BindingResult bindingResult,Model model){
        return shoppingCart;
    }

    @RequestMapping(value="/emptyCart",method = RequestMethod.POST)
    public ShoppingCart empty(Model model){

            model.addAttribute("currentShoppingCart", new ShoppingCart());


        return new ShoppingCart();
    }
    @RequestMapping(value = "/historyCart",method = RequestMethod.GET)
    public List<ShoppingCart> getHistoryCart(){
        SecurityUser securityUser = (SecurityUser)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userService.getShoppingCart(securityUser);
    }

}
