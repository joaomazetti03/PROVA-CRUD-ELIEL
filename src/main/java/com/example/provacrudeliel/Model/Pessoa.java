package com.example.provacrudeliel.Model;

import jakarta.persistence.*;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private int cpf;

    @OneToOne
    @JoinColumn(name = "trabalho_id")
    private Trabalho trabalho;

    public Pessoa () {}

    public Pessoa(String nome, String sobrenome, int cpf, Trabalho trabalho) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.trabalho = trabalho;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public Trabalho getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
    }
}

