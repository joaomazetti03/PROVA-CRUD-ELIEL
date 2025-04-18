package com.example.provacrudeliel.Controller;

import com.example.provacrudeliel.DTO.TrabalhoCreateDTO;
import com.example.provacrudeliel.DTO.TrabalhoDTO;
import com.example.provacrudeliel.Service.TrabalhoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Trabalho API", description = "Gerenciador do Trabalho Controller")
@RestController
@RequestMapping("/trabalhos")
public class TrabalhoController {

    @Autowired
    private TrabalhoService service;
    @Autowired
    private TrabalhoService trabalhoService;

    @Operation(description = "Cria Trabalho")
    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Trabalho criado")
    })
    public TrabalhoDTO create(@RequestBody TrabalhoCreateDTO dto) {
        return service.create(dto);
    }

    @Operation(description = "Lista Trabalhos")
    @GetMapping
    @ApiResponses(value = {
            @ApiResponse(description = "200", responseCode = "Lista todos os Trabalhos"),
            @ApiResponse(description = "404", responseCode = "Não exitem Trabalhos cadastrados")
    })
    public List<TrabalhoDTO> listar() {
        return service.listar();
    }

    @Operation(description = "Busca Trabalho por ID")
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Trabalho localizado"),
            @ApiResponse(responseCode = "404", description = "Trabalho não encontrado")
    })
    public TrabalhoDTO buscar(@PathVariable Long id) {
        return service.buscar(id);
    }

    @Operation(description = "Atualiza trabalho por ID")
    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Trabalho atualizado"),
            @ApiResponse(responseCode = "404", description = "Trabalho não existe")
    })
    public TrabalhoDTO atualizarTrabalho(@PathVariable Long id, @RequestBody TrabalhoCreateDTO dto) {
        return trabalhoService.atualizar(id, dto);
    }

    @Operation(description = "Deleta trabalho por ID")
    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Trabalho deletado"),
            @ApiResponse(responseCode = "404", description = "Trabalho não encontrado")
    })
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}