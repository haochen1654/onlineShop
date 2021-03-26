package com.laioffer.onlineShop.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.laioffer.onlineShop.dao.SalesOrderDao;
import com.laioffer.onlineShop.entity.SalesOrder;

import javax.persistence.EntityManagerFactory;

@Service
@Component
public class SalesOrderService {

    @Autowired
    private SalesOrderDao salesOrderDao;

    private SessionFactory hibernateFactory;

    @Autowired
    public SalesOrderService(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.hibernateFactory = factory.unwrap(SessionFactory.class);
    }


    public void addSalesOrder(SalesOrder salesOrder) {
        salesOrderDao.addSalesOrder(salesOrder);
    }
}

