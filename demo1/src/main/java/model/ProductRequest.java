package model;

import lombok.Data;

@Data
public class ProductRequest {
    private String id;
    private double amount;
    private String type;
}