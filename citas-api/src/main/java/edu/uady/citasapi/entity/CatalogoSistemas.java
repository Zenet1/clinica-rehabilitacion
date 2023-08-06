package edu.uady.citasapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

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

   



}
