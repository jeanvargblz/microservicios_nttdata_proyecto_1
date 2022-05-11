package com.proyecto1.banca.model;

import lombok.Data;

@Data
public class Product {

    private String id; //Id del producto
    private double commission; // comisiones
    private int maximunMovements; //limite maximos de movimientos
    private int credit; //credito bancario (efectivo)
    private double balance; //saldo

}
