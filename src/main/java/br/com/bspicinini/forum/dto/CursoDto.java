package br.com.bspicinini.forum.dto;

import br.com.bspicinini.forum.model.Curso;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CursoDto {

    private Long id;
    private String nome;
    private String categoria;

    public CursoDto(Curso curso) {
        this.id = curso.getId();
        this.nome = curso.getNome();
        this.categoria = curso.getCategoria();
    }
}
