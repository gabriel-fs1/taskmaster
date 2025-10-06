package br.ifsp.taskmaster.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskUpdatePartiallyDTO {

    @NotBlank(message = "O título é obrigatório")
    @Size(min = 2, message = "O título deve ter no mínimo 2 caracteres")
    private Optional<String> titulo = Optional.empty();

    @NotBlank(message = "A descrição é obrigatória")
    @Size(min = 10, message = "A descrição deve ter no mínimo 10 caracteres")
    private Optional<String> descricao = Optional.empty();

    @NotBlank(message = "A categoria é obrigatória")
    private Optional<String> categoria = Optional.empty();

    @NotNull(message = "A data limite é obrigatória")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Optional<LocalDate> dataLimite = Optional.empty();
}