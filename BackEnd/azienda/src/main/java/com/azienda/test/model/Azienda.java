package com.azienda.test.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Azienda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String nomeAzienda;

    @OneToMany(mappedBy = "azienda")
    private List<Dipendente> dipendenti;

}
