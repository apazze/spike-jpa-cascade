package com.example.spike_jpa_cascade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepo extends JpaRepository<Pessoa, Long> {
}
