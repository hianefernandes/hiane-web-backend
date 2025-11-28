package com.tiaNanda.receitas.service;

import com.tiaNanda.receitas.dto.ReceitaRequestDTO;
import com.tiaNanda.receitas.dto.ReceitaResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ReceitaService {

    ReceitaResponseDTO criar(ReceitaRequestDTO dto);

    ReceitaResponseDTO atualizar(Long id, ReceitaRequestDTO dto);

    void deletar(Long id);

    ReceitaResponseDTO buscarPorId(Long id);

    List<ReceitaResponseDTO> listarTodas();

    Page<ReceitaResponseDTO> listarPaginado(int page, int size, String sortBy);
}