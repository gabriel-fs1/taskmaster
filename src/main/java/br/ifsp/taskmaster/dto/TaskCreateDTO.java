package br.ifsp.taskmaster.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskCreateDTO {
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
}
