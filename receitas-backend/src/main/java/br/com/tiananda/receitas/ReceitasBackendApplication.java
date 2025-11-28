package com.tiaNanda.receitas;

import com.tiaNanda.receitas.entity.Receita;
import com.tiaNanda.receitas.repository.ReceitaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Classe principal da aplicação.
 * Contém um bean CommandLineRunner que injeta dados iniciais em ambiente de desenvolvimento.
 */
@SpringBootApplication
public class ReceitasBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReceitasBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner init(ReceitaRepository repo) {
        return args -> {
            if (repo.count() == 0) {
                repo.save(Receita.builder()
                        .nome("Bolo de Cenoura")
                        .descricao("Bolo macio de cenoura com cobertura de chocolate.")
                        .ingredientes("cenoura, ovos, açúcar, óleo, farinha, fermento")
                        .tempoMinutos(60)
                        .categoria("Doce")
                        .imageUrl("https://source.unsplash.com/featured/?cake")
                        .build());

                repo.save(Receita.builder()
                        .nome("Macarrão ao Alho e Óleo")
                        .descricao("Macarrão simples, rápido e saboroso.")
                        .ingredientes("macarrão, alho, azeite, sal, pimenta")
                        .tempoMinutos(20)
                        .categoria("Prato Principal")
                        .imageUrl("https://source.unsplash.com/featured/?pasta")
                        .build());
            }
        };
    }
}