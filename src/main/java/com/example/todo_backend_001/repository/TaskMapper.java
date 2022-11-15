package com.example.todo_backend_001.repository;

import com.example.todo_backend_001.entity.Task;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskMapper implements RowMapper<Task> {
    public Task mapRow(ResultSet rs, int rowNum) throws SQLException{
        Task task = new Task();
        task.setId(rs.getInt("id"));
        task.setName(rs.getString("name"));
        task.setTimeNeeded(rs.getInt("timeNeeded"));
        task.setShift(rs.getString("shift"));
        task.setProgress(rs.getString("progress"));
        task.setDate(rs.getString("startDate"));
        return task;
    }
}
