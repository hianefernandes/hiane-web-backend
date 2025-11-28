package com.tiaNanda.receitas.service.impl;

import com.tiaNanda.receitas.dto.ReceitaRequestDTO;
import com.tiaNanda.receitas.dto.ReceitaResponseDTO;
import com.tiaNanda.receitas.entity.Receita;
import com.tiaNanda.receitas.exception.ResourceNotFoundException;
import com.tiaNanda.receitas.mapper.ReceitaMapper;
import com.tiaNanda.receitas.repository.ReceitaRepository;
import com.tiaNanda.receitas.service.ReceitaService;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReceitaServiceImpl implements ReceitaService {

    private final ReceitaRepository repository;

    public ReceitaServiceImpl(ReceitaRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public ReceitaResponseDTO criar(ReceitaRequestDTO dto) {
        Receita entity = ReceitaMapper.toEntity(dto);
        Receita saved = repository.save(entity);
        return ReceitaMapper.toResponse(saved);
    }

    @Override
    @Transactional
    public ReceitaResponseDTO atualizar(Long id, ReceitaRequestDTO dto) {
        Receita existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Receita não encontrada com id: " + id));
        ReceitaMapper.updateEntityFromDto(dto, existing);
        Receita updated = repository.save(existing);
        return ReceitaMapper.toResponse(updated);
    }

    @Override
    @Transactional
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Receita não encontrada com id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public ReceitaResponseDTO buscarPorId(Long id) {
        Receita entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Receita não encontrada com id: " + id));
        return ReceitaMapper.toResponse(entity);
    }

    @Override
    public List<ReceitaResponseDTO> listarTodas() {
        return repository.findAll()
                .stream()
                .map(ReceitaMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Page<ReceitaResponseDTO> listarPaginado(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Receita> slice = repository.findAll(pageable);
        return slice.map(ReceitaMapper::toResponse);
    }
}