package com.proyecto1.banca.model;

import lombok.Data;

@Data
public class History {

    private String id;
    private double amounToDay; // Monto de hoy y/o Actual
    private String idOpreration; // Id operacion
    private String dateOperation; // Fecha de operacion
    private String idClient; // Id cliente
    private String placeOperation; // Lugar de Operacion
}
