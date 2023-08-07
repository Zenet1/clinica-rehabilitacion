package edu.uady.citasapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "catalogo_sistemas")
@Data
@NoArgsConstructor

public class CatalogoSistemas {
	
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column(name = "sistema", length = 60)
    private String sistema;

    @Column(name = "subsistema", length = 60)
    private String subsistema;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sistema")
    @JsonIgnore
    private List<Diagnostico>  diagnosticos;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sistema")
    @JsonIgnore
    private List<Revaloracion>  revaloraciones;
   



}
