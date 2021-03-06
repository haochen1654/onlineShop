package com.laioffer.onlineShop;

import java.math.BigDecimal;

import com.laioffer.onlineShop.log.PaymentAction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("payment.xml"); // container
        PaymentAction paymentAction = (PaymentAction) container.getBean("paymentAction");
        paymentAction.pay(new BigDecimal(2));
    }
}

