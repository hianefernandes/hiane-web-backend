package com.tiaNanda.receitas.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReceitaResponseDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String ingredientes;
    private Integer tempoMinutos;
    private String categoria;
    private String imageUrl;
}