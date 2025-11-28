package com.tiaNanda.receitas.mapper;

import com.tiaNanda.receitas.dto.ReceitaRequestDTO;
import com.tiaNanda.receitas.dto.ReceitaResponseDTO;
import com.tiaNanda.receitas.entity.Receita;

public class ReceitaMapper {

    // Converte DTO de requisição para entidade
    public static Receita toEntity(ReceitaRequestDTO dto) {
        if (dto == null) return null;
        return Receita.builder()
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .ingredientes(dto.getIngredientes())
                .tempoMinutos(dto.getTempoMinutos())
                .categoria(dto.getCategoria())
                .imageUrl(dto.getImageUrl())
                .build();
    }

    // Converte entidade para DTO de resposta
    public static ReceitaResponseDTO toResponse(Receita r) {
        if (r == null) return null;
        return ReceitaResponseDTO.builder()
                .id(r.getId())
                .nome(r.getNome())
                .descricao(r.getDescricao())
                .ingredientes(r.getIngredientes())
                .tempoMinutos(r.getTempoMinutos())
                .categoria(r.getCategoria())
                .imageUrl(r.getImageUrl())
                .build();
    }

    // Atualiza uma entidade existente com dados do DTO (não altera id)
    public static void updateEntityFromDto(ReceitaRequestDTO dto, Receita entity) {
        if (dto == null || entity == null) return;
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setIngredientes(dto.getIngredientes());
        entity.setTempoMinutos(dto.getTempoMinutos());
        entity.setCategoria(dto.getCategoria());
        entity.setImageUrl(dto.getImageUrl());
    }
}