package com.example.provacrudeliel.Service;

import com.example.provacrudeliel.DTO.TrabalhoCreateDTO;
import com.example.provacrudeliel.DTO.TrabalhoDTO;
import com.example.provacrudeliel.Model.Trabalho;
import com.example.provacrudeliel.Repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository repo;

    public TrabalhoDTO create(TrabalhoCreateDTO dto) {
        Trabalho trabalho = new Trabalho(dto.getCargo(), dto.getSalario());
        trabalho = repo.save(trabalho);
        return new TrabalhoDTO(trabalho.getId(), trabalho.getCargo(), trabalho.getSalario());
    }

    public List<TrabalhoDTO> listar() {
        return repo.findAll().stream().map(t -> new TrabalhoDTO(t.getId(), t.getCargo(), t.getSalario())).collect(Collectors.toList());
    }

    public TrabalhoDTO buscar(Long id) {
        return repo.findById(id).map(t -> new TrabalhoDTO(t.getId(), t.getCargo(), t.getSalario())).orElse(null);
    }

    public TrabalhoDTO atualizar(Long id, TrabalhoCreateDTO dto) {
        Trabalho trabalho = repo.findById(id).orElseThrow();
        trabalho.setCargo(dto.getCargo());
        trabalho.setSalario(dto.getSalario());
        trabalho = repo.save(trabalho);
        return new TrabalhoDTO(trabalho.getId(), trabalho.getCargo(), trabalho.getSalario());
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }
}