package com.laioffer.onlineShop.service;

import com.laioffer.onlineShop.entity.Cart;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.laioffer.onlineShop.dao.CustomerDao;
import com.laioffer.onlineShop.entity.Customer;

import javax.persistence.EntityManagerFactory;

@Service
@Component
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    private SessionFactory hibernateFactory;


    @Autowired
    public CustomerService(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.hibernateFactory = factory.unwrap(SessionFactory.class);
    }

    public void addCustomer(Customer customer) {
        customer.getUser().setEnabled(true);

        Cart cart = new Cart();
        customer.setCart(cart);

        customerDao.addCustomer(customer);
    }

    public Customer getCustomerByUserName(String userName) {
        return customerDao.getCustomerByUserName(userName);
    }
}

