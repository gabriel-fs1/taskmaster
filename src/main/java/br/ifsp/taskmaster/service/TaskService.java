package br.ifsp.taskmaster.service;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.ifsp.taskmaster.dto.TaskCreateDTO;
import br.ifsp.taskmaster.dto.TaskDTO;
import br.ifsp.taskmaster.dto.TaskUpdateDTO;
import br.ifsp.taskmaster.exception.ResourceNotFoundException;
import br.ifsp.taskmaster.model.Task;
import br.ifsp.taskmaster.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskCreateDTO createTask(TaskCreateDTO taskCreateDTO) {
        Task task = new Task(taskCreateDTO.getTitulo(), taskCreateDTO.getDescricao(), taskCreateDTO.getCategoria(), taskCreateDTO.getDataLimite());
        taskRepository.save(task);

        Task saved = taskRepository.save(task);
        return modelMapper.map(saved, TaskCreateDTO.class);
    }

    public TaskUpdateDTO updateTaskPartially(Long id, TaskUpdateDTO taskUpdDTO){
        Task existingTask = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhuma task com o id: " + id + " foi encontrada.")); 

        taskUpdDTO.getTitulo().ifPresent(existingTask::setTitulo);
        taskUpdDTO.getDescricao().ifPresent(existingTask::setDescricao);
        taskUpdDTO.getCategoria().ifPresent(existingTask::setCategoria);
        taskUpdDTO.getDataLimite().ifPresent(existingTask::setDataLimite);
        taskUpdDTO.getDataLimite().ifPresent(data -> {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("A data limite não pode ser no passado");
        }
        existingTask.setDataLimite(data);
    });
        Task savedTask = taskRepository.save(existingTask);
        return modelMapper.map(savedTask, TaskUpdateDTO.class);
    }

    public void deleteTask(long id) {
        if (!taskRepository.existsById(id)) {
            throw new ResourceNotFoundException("Nenhuma task com o id: " + id + " foi encontrada.");
        }
        taskRepository.deleteById(id);
    }

    public Page<TaskDTO> getTaskByCategoria(String categoria) {
        Page<Task> tasksPage = taskRepository.findByCategoriaIgnoreCase(categoria, Pageable.unpaged());
        return tasksPage.map(task -> modelMapper.map(task, TaskDTO.class));
    }

    public Page<TaskDTO> getAllTasks(Pageable pageable) {
        Page<Task> tasksPage = taskRepository.findAll(pageable);
        return tasksPage.map(task -> modelMapper.map(task, TaskDTO.class));
    }
}
