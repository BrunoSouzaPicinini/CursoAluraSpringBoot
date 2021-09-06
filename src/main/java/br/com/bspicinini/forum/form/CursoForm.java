package br.com.bspicinini.forum.form;

import br.com.bspicinini.forum.model.Curso;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CursoForm {

    private Long id;
    private String nome;
    private String categoria;

    public CursoForm(String nome, String categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    public Curso converter() {
        return new Curso(id, nome, categoria);
    }
}
