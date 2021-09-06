package br.com.bspicinini.forum.service;

import br.com.bspicinini.forum.exceptions.BusinessException;
import br.com.bspicinini.forum.form.CursoForm;
import br.com.bspicinini.forum.model.Curso;
import br.com.bspicinini.forum.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CursoService {

    private CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Curso cadastrar(CursoForm cursoForm) {
        Curso curso = cursoForm.converter();

        Curso retorno = cursoRepository.save(curso);

        return retorno;
    }

    public Curso alterar(Curso cursoParametro) {
        Optional<Curso> cursoConsultado = cursoRepository.findById(cursoParametro.getId());

        if(!cursoConsultado.isPresent()) {
            throw new BusinessException("Curso não encontrado " + cursoParametro.getId());
        }

        Curso curso = cursoConsultado.get();
        curso.setNome(cursoParametro.getNome());
        curso.setCategoria(cursoParametro.getCategoria());

       Curso cursoSalvo = cursoRepository.save(curso);

       cursoSalvo.setNome("Pig");

       return cursoSalvo;
    }
}
