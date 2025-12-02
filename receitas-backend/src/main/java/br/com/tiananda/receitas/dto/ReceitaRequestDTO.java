package com.tiaNanda.receitas.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReceitaRequestDTO {

    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 150, message = "Nome deve ter no máximo 150 caracteres.")
    private String nome;

    @NotBlank(message = "A descrição é obrigatória.")
    @Size(max = 3000, message = "Descrição muito longa.")
    private String descricao;

    @NotBlank(message = "Os ingredientes são obrigatórios.")
    @Size(max = 2000)
    private String ingredientes;

    @Min(value = 0, message = "Tempo inválido.")
    private Integer tempoMinutos;

    @Size(max = 100)
    private String categoria;

    @Size(max = 500)
    private String imageUrl;
}