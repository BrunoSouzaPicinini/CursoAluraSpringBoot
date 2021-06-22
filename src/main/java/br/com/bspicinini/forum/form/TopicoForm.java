package br.com.bspicinini.forum.form;

import br.com.bspicinini.forum.model.Curso;
import br.com.bspicinini.forum.model.Topico;
import br.com.bspicinini.forum.repository.CursoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class TopicoForm {

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String titulo;
    @NotNull
    @NotEmpty
    @Length(min = 10)
    private String mensagem;
    @NotNull
    @NotEmpty
    private String nomeCurso;

    public Topico converter(CursoRepository cursoRepository) {
        Curso curso = cursoRepository.findByNome(nomeCurso);
        return new Topico(titulo, mensagem, curso);
    }
}
