package com.example.provacrudeliel.DTO;

public class TrabalhoCreateDTO {
    private String cargo;
    private Double salario;

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