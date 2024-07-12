package com.example.spike_jpa_cascade;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Entity
@Accessors(chain = true)
@Data
public class Profissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nome;

    @OneToMany(mappedBy = "profissao", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    List<Pessoa> pessoas = new ArrayList<>();

    public void deletarPessoa(Pessoa pessoa) {
        this.pessoas.removeIf(p -> p.getId().equals(pessoa.getId()));
    }
}
