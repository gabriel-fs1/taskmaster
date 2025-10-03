package br.ifsp.taskmaster.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {

    private long id;
    private String titulo;
    private String descricao;
    private String categoria;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataLimite;
}