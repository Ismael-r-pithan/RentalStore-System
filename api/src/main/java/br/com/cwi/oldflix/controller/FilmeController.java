package br.com.cwi.oldflix.controller;

import br.com.cwi.oldflix.controller.dtos.request.AlterarFilmeRequest;
import br.com.cwi.oldflix.controller.dtos.request.AlugarFilmeRequest;
import br.com.cwi.oldflix.controller.dtos.request.IncluirFilmeRequest;
import br.com.cwi.oldflix.controller.dtos.response.*;
import br.com.cwi.oldflix.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    @Autowired
    private ListarFilmesService listarFilmesService;

    @Autowired
    private IncluirFilmeService incluirFilmeService;

    @Autowired
    private AlugarFilmeService alugarFilmeService;

    @Autowired
    private DevolverFilmeService devolverFilmeService;

    @Autowired
    private DetalhesFilmeService detalhesFilmeService;

    @Autowired
    private RemoverFilmeService removerFilmeService;

    @Autowired
    private AlterarFilmeService alterarFilmeService;

    @GetMapping
    public ResponseEntity<List<ListarFilmesResponse>> listarFilmes() {
        return ResponseEntity.status(OK).body(listarFilmesService.executar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesFilmeResponse> detalhes(@PathVariable Long id) {
        return ResponseEntity.status(OK).body(detalhesFilmeService.executar(id));
    }
    @PostMapping
    public ResponseEntity<IncluirFilmeResponse> salvar(@Valid @RequestBody IncluirFilmeRequest filme) {
        return ResponseEntity.status(CREATED).body(incluirFilmeService.executar(filme));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alterar(@Valid @RequestBody AlterarFilmeRequest request, @PathVariable Long id) {
        alterarFilmeService.executar(request, id);
        return ResponseEntity.status(OK).body("Filme atualizado com sucesso");
    }

    @PutMapping("/{id}/alugar")
    public ResponseEntity<AlugarFilmeResponse> alugar(@Valid @RequestBody AlugarFilmeRequest request, @PathVariable Long id) {
        return ResponseEntity.status(OK).body(alugarFilmeService.executar(id, request));
    }

    @PutMapping("/{id}/devolver")
    public ResponseEntity<DevolverFilmeResponse> devolver(@PathVariable Long id) {
        return ResponseEntity.status(OK).body(devolverFilmeService.executar(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> remover(@PathVariable Long id) {
        removerFilmeService.executar(id);
        return ResponseEntity.status(OK).body("Filme excluído com sucesso");
    }

}
