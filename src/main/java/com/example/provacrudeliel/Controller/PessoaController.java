package com.example.provacrudeliel.Controller;

import com.example.provacrudeliel.DTO.PessoaCreateDTO;
import com.example.provacrudeliel.DTO.PessoaDTO;
import com.example.provacrudeliel.Repository.PessoaRepository;
import com.example.provacrudeliel.Service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Pessoa API", description = "Gerenciador do PessoaController")
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private PessoaService pessoaService;


    @Operation(description = "Cadastrar Pessoa")
    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pessoa cadastrada")
    })
    public PessoaDTO create(@RequestBody PessoaCreateDTO dto) {
        return service.create(dto);
    }

    @Operation(description = "Listar Pessoas cadastradas")
    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna todas as pessoas cadastradas"),
            @ApiResponse(responseCode = "404", description = "Não existe pessoa cadastrada")
    })
    public List<PessoaDTO> listar() {
        return service.listar();
    }

    @Operation(description = "Buscar Pessoa por ID")
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pessoa localizada"),
            @ApiResponse(responseCode = "404", description = "Pessoa não encontrada")
    })
    public PessoaDTO buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @Operation(description = "Atualizar Pessoa")
    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pessoa atualizada"),
            @ApiResponse(responseCode = "404", description = "Pessoa não encontrada")
    })
    public PessoaDTO atualizarPessoa(@PathVariable Long id, @RequestBody PessoaCreateDTO dto) {
        return pessoaService.atualizar(id, dto);
    }

    @Operation(description = "Deletar Pessoa por ID")
    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Pessoa deletada")
    })
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}