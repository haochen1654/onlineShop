package com.laioffer.onlineShop.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.laioffer.onlineShop.dao.CartDao;
import com.laioffer.onlineShop.entity.Cart;

import javax.persistence.EntityManagerFactory;

@Service
@Component
public class CartService {

    @Autowired
    private CartDao cartDao;


    private SessionFactory hibernateFactory;


    @Autowired
    public CartService(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.hibernateFactory = factory.unwrap(SessionFactory.class);
    }


    public Cart getCartById(int cartId) {
        return cartDao.getCartById(cartId);
    }
}
