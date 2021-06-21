package br.com.bspicinini.forum.repository;

import br.com.bspicinini.forum.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Curso findByNome(String nomeCurso);
}
