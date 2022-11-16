package com.example.todo_backend_001.service;
import com.example.todo_backend_001.entity.Task;
import com.example.todo_backend_001.repository.TaskMapper;
import com.example.todo_backend_001.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final JdbcTemplate jdbcTemplate;

    public TaskService(TaskRepository taskRepository, JdbcTemplate jdbcTemplate) {
        this.taskRepository = taskRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean newUpdateSingleTaskbyID(Task current_task, int id){
        boolean findSuccess, updateSuccess;
        Task task;
        String find_query = "select * from taskTable where id = ?";
        try{
            task = jdbcTemplate.queryForObject(find_query, new TaskMapper(), id);
            findSuccess = true;
        }
        catch(Exception e){
            System.out.println("<<<<<<<<<<<<<<<<Error found>>>>>>>>>>>>>");
            System.out.println(e.getMessage());
            findSuccess = false;
        }
        if (findSuccess) {
            taskRepository.newUpdateSingleTaskbyID(current_task.getName(),id);
            return updateSuccess = true;
        }
        else{
            return updateSuccess = false;
        }
    }



    public Task getTask(Task task){
        // to experiment the post method
        // just view the input
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
        // to show all the inputted task that the frontend is going to print
        // not a necessary api
        List<Task> returnAllInputtedTask = new ArrayList<>(tasks);
        return returnAllInputtedTask;
    }


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
