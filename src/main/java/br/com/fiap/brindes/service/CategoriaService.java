package br.com.fiap.brindes.service;

import br.com.fiap.brindes.dto.request.CategoriaRequest;
import br.com.fiap.brindes.dto.response.CategoriaResponse;
import br.com.fiap.brindes.entity.Categoria;
import br.com.fiap.brindes.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service
public class CategoriaService implements ServiceDTO<Categoria, CategoriaRequest, CategoriaResponse>{

    @Autowired
    private CategoriaRepository repo;

    @Override
    public Collection<Categoria> findAll(Example<Categoria> example) {
        return repo.findAll(example);
    }

    @Override
    public Categoria findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Categoria save(Categoria e) {
    	if (repo.findByNomeCategoria(e.getNome()) != null) {
            throw new RuntimeException("Já existe uma categoria com esse nome.");
        }
        return repo.save(e);
    }

    @Override
    public Categoria toEntity(CategoriaRequest dto) {
        return Categoria.builder()
                .nome(dto.nome())
                .build();
    }

    @Override
    public CategoriaResponse toResponse(Categoria e) {
        return CategoriaResponse.builder()
                .nome(e.getNome())
                .build();
    }
}