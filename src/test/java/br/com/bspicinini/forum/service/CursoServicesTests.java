package br.com.bspicinini.forum.service;

import br.com.bspicinini.forum.exceptions.BusinessException;
import br.com.bspicinini.forum.form.CursoForm;
import br.com.bspicinini.forum.model.Curso;
import br.com.bspicinini.forum.repository.CursoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

public class CursoServicesTests {

    private CursoService subject;
    private CursoRepository cursoRepository;

    @BeforeEach
    public void beforeEach() throws Exception {
        cursoRepository = mock(CursoRepository.class);

        subject = new CursoService(cursoRepository);
    }

    @Test
    public void cadastrarHappyDay() {
        Curso curso = new Curso(2L, "Curso de Testes Unitários", "Testes");
        when(cursoRepository.save(any(Curso.class))).thenReturn(curso);

        CursoForm cursoForm = new CursoForm("Curso de Testes Unitários", "Testes");

        subject.cadastrar(cursoForm);

        verify(cursoRepository, times(1))
                .save(argThat(x -> x.getNome().equals(cursoForm.getNome()) && x.getCategoria().equals(cursoForm.getCategoria())));
    }

    @Test
    public void alterarHappyDay() {
        Optional<Curso> cursoConsultado = Optional.of(new Curso(10L, "Curso de Jardinagem", "Vida no campo"));
        when(cursoRepository.findById(10L)).thenReturn(cursoConsultado);

        Curso cursoRetornado = new Curso(10L, "Ornintorrinco", "Austrália");
        when(cursoRepository.save(any(Curso.class))).thenReturn(cursoRetornado);

        Curso cursoParametro = new Curso(10L, "Ornintorrinco", "Austrália");

        Curso cursoRetornadoSubject = subject.alterar(cursoParametro);

        Assertions.assertEquals("Ornintorrinco", cursoRetornadoSubject.getNome());
        Assertions.assertEquals("Austrália", cursoRetornadoSubject.getCategoria());
        verify(cursoRepository, times(1))
                .findById(10L);
        verify(cursoRepository, times(1))
                .save(argThat(x -> x.getNome().equals("Ornintorrinco") && x.getCategoria().equals("Austrália")));
    }

    @Test
    public void cadastrarCursoVazioException() {
        Curso curso = new Curso(2L, "Curso de Testes Unitários", "Testes");
        doThrow(Exception.class).when(cursoRepository).save(any(Curso.class));

        CursoForm cursoForm = new CursoForm("Curso de Testes Unitários", "Testes");

        Exception exception = assertThrows(BusinessException.class, () -> subject.cadastrar(cursoForm));

    }
}
