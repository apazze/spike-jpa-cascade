package com.example.spike_jpa_cascade;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Accessors(chain = true)
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nome;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    Profissao profissao;
}
