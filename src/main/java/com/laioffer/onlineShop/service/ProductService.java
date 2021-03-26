package com.laioffer.onlineShop.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.laioffer.onlineShop.dao.ProductDao;
import com.laioffer.onlineShop.entity.Product;

import javax.persistence.EntityManagerFactory;

@Service
@Component
public class ProductService {

    @Autowired
    private ProductDao productDao;

    private SessionFactory hibernateFactory;

    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    public Product getProductById(int productId) {
        return productDao.getProductById(productId);
    }

    public void deleteProduct(int productId) {
        productDao.deleteProduct(productId);
    }

    public void addProduct(Product product){
        productDao.addProduct(product);
    }

    @Autowired
    public ProductService(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.hibernateFactory = factory.unwrap(SessionFactory.class);
    }

    public void updateProduct(Product product){
        productDao.updateProduct(product);
    }
}
