package edu.uady.pacientesapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AntecedenteFamiliarDTO {
    private String cardiopatias;
    private String alergias;
    private String diabetes;
    private String nefropatias;
    private String psiquiatricos;
    private String neurologicas;
    private String otros;
}
