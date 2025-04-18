package com.example.provacrudeliel.DTO;

public class TrabalhoDTO {
    private Long id;
    private String cargo;
    private Double salario;

    public TrabalhoDTO(Long id, String cargo, Double salario) {
        this.id = id;
        this.cargo = cargo;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
