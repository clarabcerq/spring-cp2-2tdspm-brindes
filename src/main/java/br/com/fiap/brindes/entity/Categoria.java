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
@Table(name = "TB_CATEGORIA", uniqueConstraints = {
        @UniqueConstraint(name = "UK_NOME_CATEGORIA", columnNames = {"NM_CATEGORIA"})
})
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCIA_CATEGORIA")
    @SequenceGenerator(
            name = "SEQUENCIA_CATEGORIA",
            sequenceName = "SEQUENCIA_CATEGORIA",
            allocationSize = 1
    )
    @Column(name = "ID_CATEGORIA")
    private Long id;

    @Column(name = "NM_CATEGORIA")
    private String nome;

}