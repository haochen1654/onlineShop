package com.laioffer.onlineShop.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.laioffer.onlineShop.dao.CartItemDao;
import com.laioffer.onlineShop.entity.Cart;
import com.laioffer.onlineShop.entity.CartItem;

import javax.persistence.EntityManagerFactory;

@Service
@Component
public class CartItemService {

    @Autowired
    private CartItemDao cartItemDao;
    private SessionFactory hibernateFactory;


    @Autowired
    public CartItemService(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.hibernateFactory = factory.unwrap(SessionFactory.class);
    }



    public void addCartItem(CartItem cartItem) {
        cartItemDao.addCartItem(cartItem);

    }

    public void removeCartItem(int cartItemId) {
        cartItemDao.removeCartItem(cartItemId);
    }

    public void removeAllCartItems(Cart cart) {
        cartItemDao.removeAllCartItems(cart);
    }
}

