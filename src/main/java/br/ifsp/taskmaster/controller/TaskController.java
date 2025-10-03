package br.ifsp.taskmaster.controller;

import org.springframework.web.bind.annotation.RestController;

import br.ifsp.taskmaster.service.TaskService;

import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import br.ifsp.taskmaster.dto.TaskCreateDTO;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.ifsp.taskmaster.dto.TaskDTO;
import br.ifsp.taskmaster.dto.TaskUpdateDTO;


@RestController
@RequestMapping("/tasks")
@Tag(name = "Task", description = "API para gerenciamento de task")
@Validated
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Cria uma nova task")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskCreateDTO createTask(@Valid @RequestBody TaskCreateDTO taskCreateDTO) {
        return taskService.createTask(taskCreateDTO);
    }

    @Operation(summary = "Atualiza uma task existente")
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskUpdateDTO updateTaskPartially(@PathVariable Long id, @RequestBody TaskUpdateDTO taskUpdateDTO) {
        return taskService.updateTaskPartially(id, taskUpdateDTO);
    }

    @Operation(summary = "Deleta uma task existente")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable long id) {
        taskService.deleteTask(id);
    }

    @Operation(summary = "Busca tasks por categoria")
    @GetMapping("/{categoria}")
    @ResponseStatus(HttpStatus.OK)
    public Page<TaskDTO> getTaskByCategoria(@PathVariable String categoria) {
        return taskService.getTaskByCategoria(categoria);
    }

    @Operation(summary = "Busca todas as tasks")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<TaskDTO> getAllTasks(Pageable pageable) {
        return taskService.getAllTasks(pageable);
    }
    
}
