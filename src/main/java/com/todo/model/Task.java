package com.todo.model;

public class Task {
	private int taskId;
	private String taskTitle;
	private String description;
	private String deadline;
	private String priority;
	private String status;
	private int userId;

	
	public Task() {

    }
	
	 public Task(int taskId, String taskTitle, String description,
             String deadline, String priority,
             String status, int userId) 
	 {
		 this.taskId = taskId;
		 this.taskTitle = taskTitle;
		 this.description = description;
		 this.deadline = deadline;
		 this.priority = priority;
		 this.status = status;
		 this.userId = userId;
	 }

	
	
	public int getTaskId() 
	{
        return taskId;
    }

    public void setTaskId(int taskId) 
    {
        this.taskId = taskId;
    }

    
    public String getTaskTitle() 
    {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) 
    {
        this.taskTitle = taskTitle;
    }

    public String getDescription() 
    {
        return description;
    }
    
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDeadline() 
    {
        return deadline;
    }

    public void setDeadline(String deadline) 
    {
        this.deadline = deadline;
    }

    public String getPriority() 
    {
        return priority;
        
    }
    public void setPriority(String priority) 
    {
        this.priority = priority;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    
    public int getUserId() 
    {
        return userId;
    }
    
    public void setUserId(int userId) 
    {
        this.userId = userId;
    }
	
}