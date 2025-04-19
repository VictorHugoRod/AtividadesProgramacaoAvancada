package com.unicesumar.repository;

import com.unicesumar.entities.Product;
import com.unicesumar.entities.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class VendaRepository {
    private Connection connection;

    public VendaRepository(Connection connection){
        this.connection = connection;
    }

    public void save(Venda venda) throws SQLException{
        String query = "INSERT INTO sales (id, user_id, payment_method) VALUES (?, ?, ?)";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setObject(1, venda.getId());
            statement.setObject(2, venda.getUser().getUuid());
            statement.setString(3, venda.getPaymentMethod().toString());
            statement.executeUpdate();
        }
    }

    public void saveSaleProduct(UUID saleId, UUID productId) throws SQLException{
        String query = "INSERT INTO sale_products (sale_id, product_id) VALUES (?, ?)";
        try(PreparedStatement statement = connection.prepareStatement(query)){
            statement.setObject(1, saleId);
            statement.setObject(2, productId);
            statement.executeUpdate();
        }
    }

}
