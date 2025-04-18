package com.example.provacrudeliel.Service;

import com.example.provacrudeliel.DTO.PessoaCreateDTO;
import com.example.provacrudeliel.DTO.PessoaDTO;
import com.example.provacrudeliel.Model.Pessoa;
import com.example.provacrudeliel.Model.Trabalho;
import com.example.provacrudeliel.Repository.PessoaRepository;
import com.example.provacrudeliel.Repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepo;

    @Autowired
    private TrabalhoRepository trabalhoRepo;

    public PessoaDTO create(PessoaCreateDTO dto) {
        Trabalho trabalho = trabalhoRepo.findById(dto.getTrabalhoId()).orElseThrow();
        Pessoa pessoa = new Pessoa(dto.getNome(), dto.getSobrenome(), dto.getCPF(), trabalho);
        pessoa = pessoaRepo.save(pessoa);
        return toDTO(pessoa);
    }

    public List<PessoaDTO> listar() {
        return pessoaRepo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public PessoaDTO buscar(Long id) {
        return pessoaRepo.findById(id).map(this::toDTO).orElse(null);
    }

    public PessoaDTO atualizar(Long id, PessoaCreateDTO dto) {
        Pessoa pessoa = pessoaRepo.findById(id).orElseThrow();
        Trabalho trabalho = trabalhoRepo.findById(dto.getTrabalhoId()).orElseThrow();

        pessoa.setNome(dto.getNome());
        pessoa.setCpf(dto.getCPF());
        pessoa.setTrabalho(trabalho);

        pessoa = pessoaRepo.save(pessoa);
        return toDTO(pessoa);
    }

    public void deletar(Long id) {
        pessoaRepo.deleteById(id);
    }

    private PessoaDTO toDTO(Pessoa p) {
        return new PessoaDTO(p.getId(), p.getNome(), p.getSobrenome(), p.getCpf(), p.getTrabalho().getCargo(), p.getTrabalho().getSalario());
    }
}