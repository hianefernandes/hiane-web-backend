package com.tiaNanda.receitas.repository;

import com.tiaNanda.receitas.entity.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    // consultas customizadas podem ser adicionadas aqui (ex: findByNomeContaining)
}