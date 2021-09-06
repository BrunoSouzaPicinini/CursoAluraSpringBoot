package br.com.bspicinini.forum.service;

import br.com.bspicinini.forum.form.CursoForm;
import br.com.bspicinini.forum.model.Curso;
import br.com.bspicinini.forum.repository.CursoRepository;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    private CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public Curso cadastrar(CursoForm cursoForm) {
        Curso curso = cursoForm.converter();

        return cursoRepository.save(curso);
    }
}
