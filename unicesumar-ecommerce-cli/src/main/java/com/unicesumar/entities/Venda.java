package com.unicesumar.entities;

import com.unicesumar.paymentMethods.PaymentMethod;
import java.util.List;
import java.util.UUID;

public class Venda {
    private UUID id;
    private User user;
    private List<Product> products;
    private PaymentMethod paymentMethod;

    public Venda(User user, List<Product> products, PaymentMethod paymentMethod) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.products = products;
        this.paymentMethod = paymentMethod;
    }

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
}

