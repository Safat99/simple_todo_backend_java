package com.example.todo_backend_001.repository;

import com.example.todo_backend_001.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;

@Repository
public class TaskRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    public boolean addTask(Task task){
        int i = jdbcTemplate.update(
                "insert into taskTable (id,name,shift,progress,startDate,timeNeeded) values (?,?,?,?,?,?)",
                task.getId(),task.getName(), task.getShift(), task.getProgress(), task.getDate(), task.getTimeNeeded()
        );

        System.out.println(i);
        boolean success;
        success = i == 1;
        return success;
    }

    public boolean deleteSingleTask(int id){
        int i = jdbcTemplate.update("delete from taskTable where id=?", id);
        System.out.println(i);
        boolean success;
        success = i == 1;
        return success;
    }

    /*
    public Optional < Employee > findById(long id) {
        return Optional.of(jdbcTemplate.queryForObject("select * from employees where id=?", new Object[] {
                id
            },
            new BeanPropertyRowMapper < Employee > (Employee.class)));
    }
    * */

    public boolean updateSingleTask(Task current_task,int id){
        Task task = new Task();
        boolean find_success,success;
        String find_query = "select * from taskTable where id = ?";
        try{
            task = jdbcTemplate.queryForObject(find_query, new TaskMapper(), id);
            find_success = true;
        }
        catch(Exception e){
            System.out.println("<<<<<<<<<<<<<<<<Error found>>>>>>>>>>>>>");
            System.out.println(e.getMessage());
            find_success = false;
        }
        if (find_success) {
            jdbcTemplate.update("update taskTable set name=? where id = ?", current_task.getName(), id);
            return success = true;
        }
        else{
            return success = false;
        }
    }

    public void newUpdateSingleTaskbyID(String newName, int id){
        jdbcTemplate.update("update taskTable set name=? where id=?",newName,id);
    }


    public Task getSingleTask(int id){
        // query portion
        // return all info of that row
        Task task = new Task();
        String sql = "select * from taskTable where id = ?";
        try{
            task  = jdbcTemplate.queryForObject(sql, new TaskMapper(), id);
        }
        catch(Exception e){
            System.out.println("EERORRRRRRRRRRRRRRRRRRRRR");
        }
        return task;
    }

//    @Query(value="Select * from emp" native=true);
//    public List<Emply> getAllEmpjakHZA();
//    @Query(value="Select * from emp where id=:n" native=true);
//    public Emp getAllEmpjakHZA(@Prome("n"),Emp id);
}
