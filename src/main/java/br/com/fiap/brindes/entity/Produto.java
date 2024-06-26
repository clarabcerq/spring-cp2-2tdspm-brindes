package br.com.fiap.brindes.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class Produto {

    private Long id;

    private String nome;

    private Double preco;

    private Categoria categoria;


}
