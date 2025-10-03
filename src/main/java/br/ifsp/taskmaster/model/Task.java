package br.ifsp.taskmaster.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "O título é obrigatório")
    @Size(min = 2, message = "O título deve ter no mínimo 2 caracteres")
    private String titulo;

    @NotBlank(message = "A descrição é obrigatória")
    @Size(min = 10, message = "A descrição deve ter no mínimo 10 caracteres")
    private String descricao;

    @NotBlank(message = "A categoria é obrigatória")
    private String categoria;

    @NotNull(message = "A data limite é obrigatória")
    @FutureOrPresent(message = "A data limite não pode ser no passado")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataLimite;

    public Task(String titulo, String descricao, String categoria, LocalDate dataLimite) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.dataLimite = dataLimite;
    }

    public Task() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(LocalDate dataLimite) {
        this.dataLimite = dataLimite;
    }

}