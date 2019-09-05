package com.azienda.test.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Entity
@Data
public class Dipendente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @NonNull Long id;
    private @NonNull String nome;
    private @NonNull String cognome;

    @Email
    @Column(unique = true)
    private @NonNull String email;

    @OneToOne
    private Azienda azienda;
}
