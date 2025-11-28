package com.tiaNanda.receitas.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "receitas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // título/nome da receita (obrigatório)
    @Column(nullable = false, length = 150)
    private String nome;

    // modo de preparo / descrição maior
    @Column(length = 3000)
    private String descricao;

    // ingredientes (texto)
    @Column(length = 2000)
    private String ingredientes;

    // tempo em minutos
    private Integer tempoMinutos;

    // categoria (ex.: Sobremesa, Prato Principal)
    private String categoria;

    // url da imagem
    private String imageUrl;
}