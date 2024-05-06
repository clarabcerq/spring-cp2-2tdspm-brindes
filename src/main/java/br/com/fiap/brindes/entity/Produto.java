package br.com.fiap.brindes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "TB_PRODUTO" , uniqueConstraints = {
        @UniqueConstraint(name = "UK_Nome_PRODUTO_CATEGORIA",columnNames = {"NM_PRODUTO","CATEGORIA"})
})
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCIA_PRODUTO")
    @SequenceGenerator(
            name = "SEQUENCIA_PRODUTO",
            sequenceName = "SEQUENCIA_PRODUTO",
            allocationSize = 1
    )
    @Column(name = "ID_PRODUTO")
    private Long id;

    @Column(name = "NM_PRODUTO")
    private String nome;

    @Column(name = "PRECO_PROD")
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}