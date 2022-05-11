package com.proyecto1.banca.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@Document(collection = "clients")
public class Client {
    @Id
    private long id;
    private Integer type; // Tipo de Cliente: Personal y/o Empresarial
    private String numberAccount; //Numero de Cuenta
    private Integer balance; //Saldo
    private Integer maximunMovements; // Limite maximo de movimientos
    private Integer maintenanceCost; //Costo/Comision de mantenimiento
    private Integer credit; // Credito bancario (efectivo)
}
