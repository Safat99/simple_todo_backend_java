package com.example.todo_backend_001.service;
import com.example.todo_backend_001.entity.Task;
import com.example.todo_backend_001.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
//    public TaskService(TaskRepository taskRepository) {
//        this.taskRepository = taskRepository;
//    }

    public Task getTask(Task task){
        Task returnTask = new Task();
        returnTask.setId(task.getId());
        returnTask.setDate(task.getDate());
        returnTask.setProgress(task.getProgress());
        returnTask.setName(task.getName());
        returnTask.setShift(task.getShift());
        returnTask.setTimeNeeded(task.getTimeNeeded());
        return returnTask;
    }




    public List<Task> getAllTasks(){
        ArrayList<Task>  returnAllTasks= new ArrayList<>();
//        Task task1 = new Task();
//        task1.setId(1);
//        task1.setDate("today");
//        task1.setProgress("pending");
//        task1.setName("safat");
//        task1.setShift("night");
//        task1.setTimeNeeded(6);
//
//        Task task2 = new Task();
//        task2.setId(2);
//        task2.setDate("today");
//        task2.setProgress("pending");
//        task2.setName("safat2");
//        task2.setShift("night");
//        task2.setTimeNeeded(6);
//
//        returnAllTasks.add(task1);
//        returnAllTasks.add(task2);

        /* using rowMapper portion here*/
        


        return returnAllTasks;
    }

    public List<Task> getAllInputtedTask(List<Task> tasks){

        List<Task> returnAllInputtedTask = new ArrayList<>(tasks);
        return returnAllInputtedTask;

    }
   //private final TaskRepository taskRepository;
//public Task getTaskByID(int id)
//{
//    Task task=taskRepository.getSingleTask(id);
//    if(task)
//    {
//        taskRepository.updateSingleTask(hjasg)
//    } throw new RuntimeException();
////    else{
////
////    }
//}


}
