package br.com.bspicinini.forum.controller;


import br.com.bspicinini.forum.dto.CursoDto;
import br.com.bspicinini.forum.form.CursoForm;
import br.com.bspicinini.forum.model.Curso;
import br.com.bspicinini.forum.service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/curso")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CursoDto> cadastrar(@RequestBody @Valid CursoForm cursoForm, UriComponentsBuilder uriComponentsBuilder) {
        Curso curso = cursoService.cadastrar(cursoForm);

        URI uri = uriComponentsBuilder.path("/curso/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(uri).body(new CursoDto(curso));
    }
}
