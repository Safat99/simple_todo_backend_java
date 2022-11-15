package com.example.todo_backend_001.controller;
import com.example.todo_backend_001.entity.Task;
import com.example.todo_backend_001.service.TaskService;
import com.example.todo_backend_001.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    private final TaskService taskService;
    private final TaskRepository taskRepository;

    public TaskController(TaskService taskService, TaskRepository taskRepository) {
        this.taskService = taskService;
        this.taskRepository = taskRepository;
    }

    @PostMapping ("/single_task")
    public Task singleTask(@RequestBody Task task){
        return taskService.getTask(task);
    }

    @GetMapping("/get_all_task")
    public List<Task> allTasks(){
        return taskService.getAllTasks();
    }

    @PostMapping("get_all_inputted_task")
    public List<Task> all_inputtedTask(@RequestBody List<Task> all_inputted_task){
        return taskService.getAllInputtedTask(all_inputted_task);
    }

    @PostMapping("/save_single_task")
    public boolean saveTask(@RequestBody Task task){
        return taskRepository.addTask(task);
    }

    @PostMapping("/save_multiple_task")
    public int saveMultipleTask(@RequestBody List<Task> tasks){
        int count = 0;
        boolean result;
        for (Task task: tasks){
          result = taskRepository.addTask(task);
          if (result)count++;
        }
        return count;
    }

    @DeleteMapping("/delete_single_task/{id}")
    public boolean deleteTask(@PathVariable("id") int id){
        // the id must be in the taskTable
        boolean success;
        return taskRepository.deleteSingleTask(id);
    }

    @PutMapping("/update_single_task/{id}")
    public boolean updateTask(@RequestBody Task task,@PathVariable("id") int id){
        boolean success;
        return taskRepository.updateSingleTask(task,id);
    }

    @GetMapping("/get_single_task/{id}")
    public Task infoSingleTask(@PathVariable("id") int id){
        return taskRepository.getSingleTask(id);
    }



}
