package com.unicesumar.repository;

import com.unicesumar.entities.Product;
import java.util.*;

public class ProductRepository implements Repository<Product> {
    private final Map<UUID, Product> productStorage = new HashMap<>();

    @Override
    public void save(Product product) {
        productStorage.put(product.getUuid(), product);
        System.out.println("Produto salvo: " + product.getName());
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return Optional.ofNullable(productStorage.get(id));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productStorage.values());
    }
}
