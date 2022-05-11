package com.proyecto1.banca.customer;

import com.proyecto1.banca.model.Product;

public interface ProductImf {
    public Product findByIdCustomer(String id);
    public Product save(Product product);
    public Product findById(String id);

}
