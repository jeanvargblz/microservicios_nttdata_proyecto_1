package com.proyecto1.banca.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@Document(collection = "employess")
public class Employee {
    @Id
    private long id;
    private String firstName;
    private String role;

}
